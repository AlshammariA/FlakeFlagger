@Test public void testGetPrincipals() throws Exception {
  String adminId=adminSession.getAuthInfo().getUserID();
  Set<? extends Principal> principals=principalProvider.getPrincipals(adminId);
  assertNotNull(principals);
  assertFalse(principals.isEmpty());
  assertTrue(principals.contains(EveryonePrincipal.getInstance()));
  boolean containsAdminPrincipal=false;
  for (  Principal principal : principals) {
    assertNotNull(principalProvider.getPrincipal(principal.getName()));
    if (principal instanceof AdminPrincipal) {
      containsAdminPrincipal=true;
    }
  }
  assertTrue(containsAdminPrincipal);
}
