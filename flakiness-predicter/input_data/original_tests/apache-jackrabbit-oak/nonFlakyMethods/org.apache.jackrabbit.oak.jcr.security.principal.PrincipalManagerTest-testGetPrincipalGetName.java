@Test public void testGetPrincipalGetName(){
  for (  Principal pcpl : adminPrincipals) {
    Principal pp=principalMgr.getPrincipal(pcpl.getName());
    assertEquals("PrincipalManager.getPrincipal returned Principal with different Name",pcpl.getName(),pp.getName());
  }
}
