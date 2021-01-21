@Test public void testGetApplicablePoliciesInternalPrincipal() throws Exception {
  Principal unknown=getPrincipalManager(root).getPrincipal("unknown");
  int i=0;
  while (unknown != null) {
    unknown=getPrincipalManager(root).getPrincipal("unknown" + i);
  }
  unknown=new PrincipalImpl("unknown" + i);
  assertEquals(1,acMgr.getApplicablePolicies(unknown).length);
}
