@Test public void testFindPrincipalByType(){
  for (  Principal pcpl : adminPrincipals) {
    if (pcpl.equals(everyone)) {
      continue;
    }
    assertTrue(principalMgr.hasPrincipal(pcpl.getName()));
    if (isGroup(pcpl)) {
      PrincipalIterator it=principalMgr.findPrincipals(pcpl.getName(),PrincipalManager.SEARCH_TYPE_GROUP);
      assertTrue("findPrincipals does not find principal with filter " + pcpl.getName(),it.hasNext());
    }
 else {
      PrincipalIterator it=principalMgr.findPrincipals(pcpl.getName(),PrincipalManager.SEARCH_TYPE_NOT_GROUP);
      assertTrue("findPrincipals does not find principal with filter '" + pcpl.getName() + "' and type "+ PrincipalManager.SEARCH_TYPE_NOT_GROUP,it.hasNext());
    }
  }
}
