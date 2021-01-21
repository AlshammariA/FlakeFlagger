@Test public void testRemoveNodeWithJr2Flag2() throws Exception {
  setupPermission("/a",testPrincipal,true,PrivilegeConstants.JCR_READ,PrivilegeConstants.REP_WRITE);
  setupPermission("/a/b",testPrincipal,false,PrivilegeConstants.REP_REMOVE_PROPERTIES);
  Root testRoot=getTestRoot();
  AccessControlManager acMgr=getAccessControlManager(testRoot);
  assertTrue(acMgr.hasPrivileges("/a",privilegesFromNames(PrivilegeConstants.REP_WRITE)));
  assertFalse(acMgr.hasPrivileges("/a/b",privilegesFromNames(PrivilegeConstants.REP_REMOVE_PROPERTIES)));
  try {
    testRoot.getTree("/a").remove();
    testRoot.commit();
    fail();
  }
 catch (  CommitFailedException e) {
    assertTrue(e.isAccessViolation());
  }
}
