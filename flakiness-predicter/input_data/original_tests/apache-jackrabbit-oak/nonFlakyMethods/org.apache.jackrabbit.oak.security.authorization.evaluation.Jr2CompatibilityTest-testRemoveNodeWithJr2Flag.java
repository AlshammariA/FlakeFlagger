@Test public void testRemoveNodeWithJr2Flag() throws Exception {
  setupPermission("/a",testPrincipal,true,PrivilegeConstants.JCR_READ,PrivilegeConstants.REP_WRITE);
  setupPermission("/a/b",testPrincipal,false,PrivilegeConstants.JCR_REMOVE_NODE);
  Root testRoot=getTestRoot();
  AccessControlManager acMgr=getAccessControlManager(testRoot);
  assertTrue(acMgr.hasPrivileges("/a",privilegesFromNames(PrivilegeConstants.REP_WRITE)));
  assertFalse(acMgr.hasPrivileges("/a/b",privilegesFromNames(PrivilegeConstants.JCR_REMOVE_NODE)));
  try {
    testRoot.getTree("/a").remove();
    testRoot.commit();
    fail();
  }
 catch (  CommitFailedException e) {
    assertTrue(e.isAccessViolation());
  }
}
