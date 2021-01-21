@Test public void testCleanupForAllWorkspaces() throws RepositoryException, NotExecutableException {
  String[] workspaceNames=superuser.getWorkspace().getAccessibleWorkspaceNames();
  for (  String workspaceName1 : workspaceNames) {
    Session s=getHelper().getSuperuserSession(workspaceName1);
    try {
      UserManager umgr=getUserManager(s);
      s.logout();
      try {
        umgr.getAuthorizable("any userid");
        fail("After having logged out the original session, the user manager must not be live any more.");
      }
 catch (      RepositoryException e) {
      }
    }
  finally {
      if (s.isLive()) {
        s.logout();
      }
    }
  }
}
