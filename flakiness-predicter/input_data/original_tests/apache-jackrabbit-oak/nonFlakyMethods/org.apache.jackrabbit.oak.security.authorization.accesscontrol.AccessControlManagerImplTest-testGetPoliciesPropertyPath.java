@Test public void testGetPoliciesPropertyPath() throws Exception {
  String propertyPath="/jcr:primaryType";
  try {
    acMgr.getPolicies(propertyPath);
    fail("Getting policies for property should fail.");
  }
 catch (  PathNotFoundException e) {
  }
}
