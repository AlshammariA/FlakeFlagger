@Test public void testGetApplicablePoliciesNonExistingNodePath() throws Exception {
  String nonExistingPath="/not/existing";
  try {
    acMgr.getApplicablePolicies(nonExistingPath);
    fail("Getting applicable policies for node that doesn't exist should fail.");
  }
 catch (  PathNotFoundException e) {
  }
}
