@Test public void testCleanup() throws RepositoryException, NotExecutableException {
  Session s=getHelper().getSuperuserSession();
  try {
    UserManager umgr=getUserManager(s);
    s.logout();
    try {
      umgr.getAuthorizable("any userid");
      fail("After having logged out the original session, the user manager must not be live any more.");
    }
 catch (    RepositoryException e) {
    }
  }
  finally {
    if (s.isLive()) {
      s.logout();
    }
  }
}
