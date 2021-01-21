@Test public void testGetApplicablePoliciesInvalidPrincipal() throws Exception {
  Principal unknown=getPrincipalManager(root).getPrincipal("unknown");
  int i=0;
  while (unknown != null) {
    unknown=getPrincipalManager(root).getPrincipal("unknown" + i);
  }
  unknown=new InvalidTestPrincipal("unknown" + i);
  try {
    acMgr.getApplicablePolicies(unknown);
    fail("Unknown principal should be detected.");
  }
 catch (  AccessControlException e) {
  }
}
