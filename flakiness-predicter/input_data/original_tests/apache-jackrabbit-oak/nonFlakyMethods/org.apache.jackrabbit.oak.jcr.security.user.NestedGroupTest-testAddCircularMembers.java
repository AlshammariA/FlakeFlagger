@Test public void testAddCircularMembers() throws NotExecutableException, RepositoryException {
  Group gr1=null;
  Group gr2=null;
  try {
    gr1=createGroup(getTestPrincipal());
    gr2=createGroup(getTestPrincipal());
    assertTrue(addMember(gr1,gr2));
    assertFalse(addMember(gr2,gr1));
  }
  finally {
    if (gr1 != null && gr1.isMember(gr2)) {
      removeMember(gr1,gr2);
    }
    if (gr2 != null && gr2.isMember(gr1)) {
      removeMember(gr2,gr1);
    }
    if (gr1 != null)     removeGroup(gr1);
    if (gr2 != null)     removeGroup(gr2);
  }
}
