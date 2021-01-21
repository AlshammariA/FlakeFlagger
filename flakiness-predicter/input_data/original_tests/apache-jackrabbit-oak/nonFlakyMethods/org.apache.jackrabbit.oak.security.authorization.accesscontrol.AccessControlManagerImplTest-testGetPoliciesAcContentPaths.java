@Test public void testGetPoliciesAcContentPaths() throws Exception {
  for (  String path : getAcContentPaths()) {
    try {
      acMgr.getPolicies(path);
      fail("Getting policies for access control content should fail.");
    }
 catch (    AccessControlException e) {
    }
  }
}
