@Test public void testGetPrivilegesForPropertyPath() throws Exception {
  String propertyPath="/jcr:primaryType";
  try {
    acMgr.getPrivileges(propertyPath);
    fail("AccessControlManager#getPrivileges for property should fail.");
  }
 catch (  PathNotFoundException e) {
  }
  try {
    acMgr.getPrivileges(propertyPath,Collections.singleton(testPrincipal));
    fail("AccessControlManager#getPrivileges for property should fail.");
  }
 catch (  PathNotFoundException e) {
  }
}
