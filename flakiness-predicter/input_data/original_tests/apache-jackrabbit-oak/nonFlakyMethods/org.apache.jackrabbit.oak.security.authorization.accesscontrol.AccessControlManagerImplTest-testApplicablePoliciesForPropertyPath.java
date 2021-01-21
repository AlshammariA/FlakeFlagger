@Test public void testApplicablePoliciesForPropertyPath() throws Exception {
  String propertyPath="/jcr:primaryType";
  try {
    acMgr.getApplicablePolicies(propertyPath);
    fail("Getting applicable policies for property should fail.");
  }
 catch (  PathNotFoundException e) {
  }
}
