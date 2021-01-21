@Test public void testGetPoliciesByPrincipal() throws Exception {
  List<Principal> principals=ImmutableList.of(testPrincipal,EveryonePrincipal.getInstance());
  for (  Principal principal : principals) {
    AccessControlPolicy[] policies=acMgr.getPolicies(principal);
    assertNotNull(policies);
    assertEquals(0,policies.length);
  }
}
