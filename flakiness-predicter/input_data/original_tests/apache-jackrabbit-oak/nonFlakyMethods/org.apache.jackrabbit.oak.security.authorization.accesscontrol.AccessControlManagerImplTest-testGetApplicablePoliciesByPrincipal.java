@Test public void testGetApplicablePoliciesByPrincipal() throws Exception {
  List<Principal> principals=ImmutableList.of(testPrincipal,EveryonePrincipal.getInstance());
  for (  Principal principal : principals) {
    AccessControlPolicy[] applicable=acMgr.getApplicablePolicies(principal);
    assertNotNull(applicable);
    assertEquals(1,applicable.length);
    assertTrue(applicable[0] instanceof ACL);
  }
}
