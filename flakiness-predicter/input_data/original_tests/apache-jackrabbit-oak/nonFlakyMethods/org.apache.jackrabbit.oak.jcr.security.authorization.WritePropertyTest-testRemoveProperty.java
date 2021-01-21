@Test public void testRemoveProperty() throws Exception {
  Privilege[] privileges=privilegesFromNames(new String[]{"rep:removeProperties"});
  allow(path,privileges);
  assertHasPrivilege(path,Privilege.JCR_MODIFY_PROPERTIES,false);
  assertHasPrivilege(path,"rep:addProperties",false);
  assertHasPrivilege(path,"rep:removeProperties",true);
  assertHasPrivilege(path,"rep:alterProperties",false);
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
  assertFalse(testSession.hasPermission(propertyPath,Session.ACTION_SET_PROPERTY));
  assertTrue(testSession.hasPermission(propertyPath,Session.ACTION_REMOVE));
  try {
    testN.setProperty("newProperty","modified");
    testSession.save();
    fail();
  }
 catch (  AccessDeniedException e) {
  }
  try {
    testN.getProperty("newProperty").setValue("modified");
    testSession.save();
    fail();
  }
 catch (  AccessDeniedException e) {
  }
  testN.getProperty("newProperty").remove();
  testSession.save();
}
