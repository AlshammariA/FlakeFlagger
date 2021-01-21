@Test public void testHasPrivilegesForPropertyPath() throws Exception {
  String propertyPath="/jcr:primaryType";
  Privilege[] privs=privilegesFromNames(PrivilegeConstants.JCR_ALL);
  try {
    acMgr.hasPrivileges(propertyPath,privs);
    fail("AccessControlManager#hasPrivileges for property should fail.");
  }
 catch (  PathNotFoundException e) {
  }
  try {
    acMgr.hasPrivileges(propertyPath,getPrincipals(adminSession),privs);
    fail("AccessControlManager#hasPrivileges for property should fail.");
  }
 catch (  PathNotFoundException e) {
  }
}
