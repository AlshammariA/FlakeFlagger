@Test public void testGetEffectivePoliciesInvalidPrincipals() throws Exception {
  Principal unknown=getPrincipalManager(root).getPrincipal("unknown");
  int i=0;
  while (unknown != null) {
    unknown=getPrincipalManager(root).getPrincipal("unknown" + i);
  }
  unknown=new InvalidTestPrincipal("unknown" + i);
  try {
    acMgr.getEffectivePolicies(Collections.singleton(unknown));
    fail("Unknown principal should be detected.");
  }
 catch (  AccessControlException e) {
  }
  try {
    acMgr.getEffectivePolicies(ImmutableSet.of(unknown,EveryonePrincipal.getInstance(),testPrincipal));
    fail("Unknown principal should be detected.");
  }
 catch (  AccessControlException e) {
  }
}
