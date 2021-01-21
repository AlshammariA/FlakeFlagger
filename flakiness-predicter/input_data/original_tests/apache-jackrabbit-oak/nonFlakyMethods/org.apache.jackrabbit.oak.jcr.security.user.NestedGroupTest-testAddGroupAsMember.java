@Test public void testAddGroupAsMember() throws NotExecutableException, RepositoryException {
  Group gr1=null;
  Group gr2=null;
  try {
    gr1=createGroup(getTestPrincipal());
    gr2=createGroup(getTestPrincipal());
    assertFalse(gr1.isMember(gr2));
    assertTrue(addMember(gr1,gr2));
    assertTrue(gr1.isMember(gr2));
  }
  finally {
    if (gr1 != null) {
      removeMember(gr1,gr2);
      removeGroup(gr1);
    }
    if (gr2 != null) {
      removeGroup(gr2);
    }
  }
}
