@Test public void testGetPrincipals(){
  PrincipalIterator it=principalMgr.getPrincipals(PrincipalManager.SEARCH_TYPE_NOT_GROUP);
  while (it.hasNext()) {
    Principal p=it.nextPrincipal();
    assertFalse(isGroup(p));
  }
}
