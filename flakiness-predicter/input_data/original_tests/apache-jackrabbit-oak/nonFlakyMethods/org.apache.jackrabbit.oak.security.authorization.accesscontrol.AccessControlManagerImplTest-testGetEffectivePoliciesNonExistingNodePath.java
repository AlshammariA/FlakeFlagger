@Test public void testGetEffectivePoliciesNonExistingNodePath() throws Exception {
  String nonExistingPath="/not/existing";
  try {
    acMgr.getEffectivePolicies(nonExistingPath);
    fail("Getting policies for node that doesn't exist should fail.");
  }
 catch (  PathNotFoundException e) {
  }
}
