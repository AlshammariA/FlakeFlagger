@Test public void testFindAuthorizable() throws RepositoryException, NotExecutableException {
  Set<Principal> principals=new HashSet<Principal>();
  PrincipalManager pMgr=((JackrabbitSession)superuser).getPrincipalManager();
  Principal p=pMgr.getPrincipal(superuser.getUserID());
  if (p != null) {
    principals.add(p);
    PrincipalIterator principalIterator=pMgr.getGroupMembership(p);
    while (principalIterator.hasNext()) {
      principals.add(principalIterator.nextPrincipal());
    }
  }
  Authorizable auth;
  for (  Principal principal : principals) {
    auth=userMgr.getAuthorizable(principal);
    if (auth != null) {
      if (!auth.isGroup() && auth.hasProperty(UserConstants.REP_PRINCIPAL_NAME)) {
        String val=auth.getProperty(UserConstants.REP_PRINCIPAL_NAME)[0].getString();
        Iterator<Authorizable> users=userMgr.findAuthorizables(UserConstants.REP_PRINCIPAL_NAME,val);
        assertTrue(users.hasNext());
        Authorizable first=users.next();
        assertEquals(first.getID(),val);
        assertFalse(users.hasNext());
      }
    }
  }
}
