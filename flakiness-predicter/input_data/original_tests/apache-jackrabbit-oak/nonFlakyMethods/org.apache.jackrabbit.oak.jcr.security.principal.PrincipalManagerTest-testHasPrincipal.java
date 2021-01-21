@Test public void testHasPrincipal(){
  assertTrue(principalMgr.hasPrincipal(everyone.getName()));
  for (  Principal pcpl : adminPrincipals) {
    assertTrue(principalMgr.hasPrincipal(pcpl.getName()));
  }
}
