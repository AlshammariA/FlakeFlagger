@Test public void testCyclicMembers2() throws RepositoryException, NotExecutableException {
  Group gr1=null;
  Group gr2=null;
  Group gr3=null;
  try {
    gr1=createGroup(getTestPrincipal());
    gr2=createGroup(getTestPrincipal());
    gr3=createGroup(getTestPrincipal());
    assertTrue(addMember(gr1,gr2));
    assertTrue(addMember(gr2,gr3));
    assertFalse(addMember(gr3,gr1));
  }
  finally {
    if (gr1 != null) {
      removeMember(gr1,gr2);
    }
    if (gr2 != null) {
      removeMember(gr2,gr3);
      removeGroup(gr2);
    }
    if (gr3 != null) {
      removeMember(gr3,gr1);
      removeGroup(gr3);
    }
    if (gr1 != null)     removeGroup(gr1);
  }
}
