@Test public void testFindEveryone(){
  assertNotNull(principalProvider.getPrincipal(EveryonePrincipal.NAME));
  Map<Integer,Boolean> tests=new HashMap<Integer,Boolean>();
  tests.put(PrincipalManager.SEARCH_TYPE_ALL,Boolean.TRUE);
  tests.put(PrincipalManager.SEARCH_TYPE_GROUP,Boolean.TRUE);
  tests.put(PrincipalManager.SEARCH_TYPE_NOT_GROUP,Boolean.FALSE);
  for (  Integer searchType : tests.keySet()) {
    boolean found=false;
    Iterator<? extends Principal> it=principalProvider.findPrincipals(EveryonePrincipal.NAME,searchType);
    while (it.hasNext()) {
      Principal p=it.next();
      if (p.getName().equals(EveryonePrincipal.NAME)) {
        found=true;
      }
    }
    Boolean expected=tests.get(searchType);
    assertEquals(expected.booleanValue(),found);
  }
}
