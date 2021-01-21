@Test public void testGetSupportedPrivilegesNonExistingPath() throws Exception {
  try {
    acMgr.getSupportedPrivileges("/non/existing/node");
    fail("Nonexisting node -> PathNotFoundException expected.");
  }
 catch (  PathNotFoundException e) {
  }
}
