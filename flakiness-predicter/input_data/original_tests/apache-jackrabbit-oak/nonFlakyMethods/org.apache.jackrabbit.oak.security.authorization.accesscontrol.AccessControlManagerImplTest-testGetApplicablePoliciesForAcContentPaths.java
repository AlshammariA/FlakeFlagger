@Test public void testGetApplicablePoliciesForAcContentPaths() throws Exception {
  for (  String path : getAcContentPaths()) {
    try {
      acMgr.getApplicablePolicies(path);
      fail("Getting applicable policies for access control content should fail.");
    }
 catch (    AccessControlException e) {
    }
  }
}
