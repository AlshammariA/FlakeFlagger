@Test public void testGetEffectivePoliciesNullPrincipal() throws Exception {
  try {
    acMgr.getEffectivePolicies((Set)null);
    fail("Null principal set not allowed");
  }
 catch (  AccessControlException e) {
  }
  try {
    acMgr.getEffectivePolicies(new HashSet<Principal>(Arrays.asList(EveryonePrincipal.getInstance(),null,testPrincipal)));
    fail("Null principal set not allowed");
  }
 catch (  AccessControlException e) {
  }
}
