@Test public void testFindEveryone(){
  Principal everyone=principalMgr.getEveryone();
  assertTrue(principalMgr.hasPrincipal(everyone.getName()));
  boolean containedInResult=false;
  PrincipalIterator it=principalMgr.findPrincipals(everyone.getName());
  while (it.hasNext()) {
    Principal p=it.nextPrincipal();
    if (p.getName().equals(everyone.getName())) {
      containedInResult=true;
    }
  }
  assertTrue(containedInResult);
  containedInResult=false;
  it=principalMgr.findPrincipals(everyone.getName(),PrincipalManager.SEARCH_TYPE_GROUP);
  while (it.hasNext()) {
    Principal p=it.nextPrincipal();
    if (p.getName().equals(everyone.getName())) {
      containedInResult=true;
    }
  }
  assertTrue(containedInResult);
  containedInResult=false;
  it=principalMgr.findPrincipals(everyone.getName(),PrincipalManager.SEARCH_TYPE_NOT_GROUP);
  while (it.hasNext()) {
    Principal p=it.nextPrincipal();
    if (p.getName().equals(everyone.getName())) {
      containedInResult=true;
    }
  }
  assertFalse(containedInResult);
}
