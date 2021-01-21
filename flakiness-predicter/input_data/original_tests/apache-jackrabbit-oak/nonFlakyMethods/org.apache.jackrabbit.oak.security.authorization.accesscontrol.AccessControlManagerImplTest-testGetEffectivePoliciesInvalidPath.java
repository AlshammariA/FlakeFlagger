@Test public void testGetEffectivePoliciesInvalidPath() throws Exception {
  for (  String invalid : getInvalidPaths()) {
    try {
      acMgr.getEffectivePolicies(invalid);
      fail("Getting policies for an invalid path should fail");
    }
 catch (    RepositoryException e) {
    }
  }
}
