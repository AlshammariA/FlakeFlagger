@Test public void testHasPrivilegesNonExistingNodePath() throws Exception {
  String nonExistingPath="/not/existing";
  Privilege[] privs=privilegesFromNames(PrivilegeConstants.JCR_ALL);
  try {
    acMgr.hasPrivileges(nonExistingPath,privs);
    fail("AccessControlManager#hasPrivileges  for node that doesn't exist should fail.");
  }
 catch (  PathNotFoundException e) {
  }
  try {
    acMgr.hasPrivileges(nonExistingPath,getPrincipals(adminSession),privs);
    fail("AccessControlManager#hasPrivileges  for node that doesn't exist should fail.");
  }
 catch (  PathNotFoundException e) {
  }
}
