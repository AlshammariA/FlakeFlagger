@Test public void testFindPrincipal(){
  for (  Principal pcpl : adminPrincipals) {
    if (pcpl.equals(everyone)) {
      continue;
    }
    assertTrue(principalMgr.hasPrincipal(pcpl.getName()));
    PrincipalIterator it=principalMgr.findPrincipals(pcpl.getName());
    assertTrue("findPrincipals does not find principal with filter '" + pcpl.getName() + '\'',it.hasNext());
  }
}
