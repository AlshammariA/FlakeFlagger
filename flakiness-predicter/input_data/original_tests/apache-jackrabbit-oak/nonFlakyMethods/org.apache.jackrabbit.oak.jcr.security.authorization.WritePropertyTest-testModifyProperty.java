@Test public void testModifyProperty() throws Exception {
  Privilege[] privileges=privilegesFromNames(new String[]{"rep:alterProperties"});
  allow(path,privileges);
  assertHasPrivilege(path,Privilege.JCR_MODIFY_PROPERTIES,false);
  assertHasPrivilege(path,"rep:addProperties",false);
  assertHasPrivilege(path,"rep:removeProperties",false);
  assertHasPrivilege(path,"rep:alterProperties",true);
  String propertyPath=path + "/newProperty";
  assertFalse(testSession.hasPermission(propertyPath,Session.ACTION_SET_PROPERTY));
  Node testN=testSession.getNode(path);
  try {
    testN.setProperty("newProperty","value");
    testSession.save();
    fail();
  }
 catch (  AccessDeniedException e) {
    testSession.refresh(false);
  }
  superuser.getNode(path).setProperty("newProperty","value");
  superuser.save();
  testSession.refresh(false);
  assertTrue(testSession.hasPermission(propertyPath,Session.ACTION_SET_PROPERTY));
  assertFalse(testSession.hasPermission(propertyPath,Session.ACTION_REMOVE));
  testN.setProperty("newProperty","modified");
  testSession.save();
  testN.getProperty("newProperty").setValue("modified2");
  testSession.save();
  try {
    testN.setProperty("newProperty",(String)null);
    testSession.save();
    fail();
  }
 catch (  AccessDeniedException e) {
    testSession.refresh(false);
  }
  try {
    testN.getProperty("newProperty").remove();
    testSession.save();
    fail();
  }
 catch (  AccessDeniedException e) {
    testSession.refresh(false);
  }
}
