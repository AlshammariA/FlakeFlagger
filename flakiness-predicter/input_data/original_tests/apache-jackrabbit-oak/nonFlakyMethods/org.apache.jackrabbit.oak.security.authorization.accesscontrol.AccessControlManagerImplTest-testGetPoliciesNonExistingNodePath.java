@Test public void testGetPoliciesNonExistingNodePath() throws Exception {
  String nonExistingPath="/not/existing";
  try {
    acMgr.getPolicies(nonExistingPath);
    fail("Getting policies for node that doesn't exist should fail.");
  }
 catch (  PathNotFoundException e) {
  }
}
