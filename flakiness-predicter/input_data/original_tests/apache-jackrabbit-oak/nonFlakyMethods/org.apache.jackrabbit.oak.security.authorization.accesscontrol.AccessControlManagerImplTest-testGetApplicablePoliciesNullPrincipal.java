@Test public void testGetApplicablePoliciesNullPrincipal() throws Exception {
  try {
    acMgr.getApplicablePolicies((Principal)null);
    fail("Null is not a valid principal");
  }
 catch (  AccessControlException e) {
  }
}
