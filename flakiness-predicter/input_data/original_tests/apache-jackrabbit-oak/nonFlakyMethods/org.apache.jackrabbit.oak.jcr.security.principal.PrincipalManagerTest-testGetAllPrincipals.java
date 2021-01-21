@Test public void testGetAllPrincipals(){
  PrincipalIterator it=principalMgr.getPrincipals(PrincipalManager.SEARCH_TYPE_ALL);
  while (it.hasNext()) {
    Principal p=it.nextPrincipal();
    assertTrue(principalMgr.hasPrincipal(p.getName()));
    assertEquals(principalMgr.getPrincipal(p.getName()),p);
  }
}
