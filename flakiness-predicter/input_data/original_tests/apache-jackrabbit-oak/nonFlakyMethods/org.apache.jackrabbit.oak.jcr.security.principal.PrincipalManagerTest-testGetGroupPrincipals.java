@Test public void testGetGroupPrincipals(){
  PrincipalIterator it=principalMgr.getPrincipals(PrincipalManager.SEARCH_TYPE_GROUP);
  while (it.hasNext()) {
    Principal p=it.nextPrincipal();
    assertTrue(isGroup(p));
  }
}
