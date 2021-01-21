@Test public void testGetEffectivePoliciesForAcContentPaths() throws Exception {
  for (  String path : getAcContentPaths()) {
    try {
      acMgr.getEffectivePolicies(path);
      fail("Getting effective policies for access control content should fail.");
    }
 catch (    AccessControlException e) {
    }
  }
}
