@Test public void testGetApplicablePoliciesInvalidPath() throws Exception {
  for (  String invalid : getInvalidPaths()) {
    try {
      acMgr.getPolicies(invalid);
      fail("Getting applicable policies for an invalid path should fail");
    }
 catch (    RepositoryException e) {
    }
  }
}
