@Test public void testGetPrivilegesNonExistingNodePath() throws Exception {
  String nonExistingPath="/not/existing";
  try {
    acMgr.getPrivileges(nonExistingPath);
    fail("AccessControlManager#getPrivileges  for node that doesn't exist should fail.");
  }
 catch (  PathNotFoundException e) {
  }
  try {
    acMgr.getPrivileges(nonExistingPath,Collections.singleton(testPrincipal));
    fail("AccessControlManager#getPrivileges  for node that doesn't exist should fail.");
  }
 catch (  PathNotFoundException e) {
  }
}
