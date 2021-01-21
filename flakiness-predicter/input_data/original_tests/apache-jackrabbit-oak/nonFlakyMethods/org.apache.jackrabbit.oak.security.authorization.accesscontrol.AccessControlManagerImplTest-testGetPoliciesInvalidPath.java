@Test public void testGetPoliciesInvalidPath() throws Exception {
  for (  String invalid : getInvalidPaths()) {
    try {
      acMgr.getPolicies(invalid);
      fail("Getting policies for an invalid path should fail");
    }
 catch (    RepositoryException e) {
    }
  }
}
