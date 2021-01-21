@Test public void testInheritedMembership() throws NotExecutableException, RepositoryException {
  Group gr1=null;
  Group gr2=null;
  Group gr3=null;
  if (!(superuser instanceof JackrabbitSession)) {
    throw new NotExecutableException();
  }
  try {
    gr1=createGroup(getTestPrincipal());
    gr2=createGroup(getTestPrincipal());
    gr3=createGroup(getTestPrincipal());
    assertTrue(addMember(gr1,gr2));
    assertTrue(addMember(gr2,gr3));
    boolean isMember=false;
    PrincipalManager pmgr=((JackrabbitSession)superuser).getPrincipalManager();
    for (PrincipalIterator it=pmgr.getGroupMembership(gr3.getPrincipal()); it.hasNext() && !isMember; ) {
      isMember=it.nextPrincipal().equals(gr1.getPrincipal());
    }
    assertTrue(isMember);
  }
  finally {
    if (gr1 != null && gr1.isMember(gr2)) {
      removeMember(gr1,gr2);
    }
    if (gr2 != null && gr2.isMember(gr3)) {
      removeMember(gr2,gr3);
    }
    if (gr1 != null)     removeGroup(gr1);
    if (gr2 != null)     removeGroup(gr2);
    if (gr3 != null)     removeGroup(gr3);
  }
}
