@Test public void testGetPoliciesNullPrincipal() throws Exception {
  try {
    acMgr.getPolicies((Principal)null);
    fail("Null is not a valid principal");
  }
 catch (  AccessControlException e) {
  }
}
