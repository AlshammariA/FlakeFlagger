@Test public void testGetPoliciesInternalPrincipal() throws Exception {
  Principal unknown=getPrincipalManager(root).getPrincipal("unknown");
  int i=0;
  while (unknown != null) {
    unknown=getPrincipalManager(root).getPrincipal("unknown" + i);
  }
  unknown=new PrincipalImpl("unknown" + i);
  assertEquals(0,acMgr.getPolicies(unknown).length);
}
