@Test public void testGetEffectivePoliciesForPropertyPath() throws Exception {
  String propertyPath="/jcr:primaryType";
  try {
    acMgr.getEffectivePolicies(propertyPath);
    fail("Getting policies for property should fail.");
  }
 catch (  PathNotFoundException e) {
  }
}
