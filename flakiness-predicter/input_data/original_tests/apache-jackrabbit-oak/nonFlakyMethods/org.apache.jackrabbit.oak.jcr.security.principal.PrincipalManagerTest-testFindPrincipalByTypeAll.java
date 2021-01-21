@Test public void testFindPrincipalByTypeAll(){
  for (  Principal pcpl : adminPrincipals) {
    if (pcpl.equals(everyone)) {
      continue;
    }
    assertTrue(principalMgr.hasPrincipal(pcpl.getName()));
    PrincipalIterator it=principalMgr.findPrincipals(pcpl.getName(),PrincipalManager.SEARCH_TYPE_ALL);
    PrincipalIterator it2=principalMgr.findPrincipals(pcpl.getName());
    assertTrue("Principal " + pcpl.getName() + " not found",it.hasNext());
    assertTrue("Principal " + pcpl.getName() + " not found",it2.hasNext());
    assertTrue(it.getSize() == it2.getSize());
    Set<Principal> s1=new HashSet<Principal>();
    Set<Principal> s2=new HashSet<Principal>();
    while (it.hasNext() && it2.hasNext()) {
      s1.add(it.nextPrincipal());
      s2.add(it2.nextPrincipal());
    }
    assertEquals(s1,s2);
    assertFalse(it.hasNext() && it2.hasNext());
  }
}
