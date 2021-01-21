@Test public void testAddProperty() throws Exception {
  Privilege[] privileges=privilegesFromNames(new String[]{"rep:addProperties"});
  allow(path,privileges);
  assertHasPrivilege(path,Privilege.JCR_MODIFY_PROPERTIES,false);
  assertHasPrivilege(path,"rep:addProperties",true);
  assertHasPrivilege(path,"rep:removeProperties",false);
  assertHasPrivilege(path,"rep:alterProperties",false);
  String propertyPath=path + "/newProperty";
  assertTrue(testSession.hasPermission(propertyPath,Session.ACTION_SET_PROPERTY));
  Node testN=testSession.getNode(path);
  testN.setProperty("newProperty","value");
  testSession.save();
  assertFalse(testSession.hasPermission(propertyPath,Session.ACTION_SET_PROPERTY));
  assertFalse(testSession.hasPermission(propertyPath,Session.ACTION_REMOVE));
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
