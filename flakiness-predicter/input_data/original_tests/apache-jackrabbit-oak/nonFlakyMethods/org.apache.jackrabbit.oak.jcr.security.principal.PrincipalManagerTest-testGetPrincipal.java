@Test public void testGetPrincipal(){
  Principal p=principalMgr.getPrincipal(everyone.getName());
  assertEquals(everyone,p);
  for (  Principal pcpl : adminPrincipals) {
    Principal pp=principalMgr.getPrincipal(pcpl.getName());
    assertEquals("PrincipalManager.getPrincipal returned Principal with different Name",pcpl.getName(),pp.getName());
  }
}
