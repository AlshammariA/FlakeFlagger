@Test public void testProtectedUserProperties() throws NotExecutableException, RepositoryException {
  Node n=getNode(user,superuser);
  if (n.hasProperty(UserConstants.REP_PASSWORD)) {
    checkProtected(n.getProperty(UserConstants.REP_PASSWORD));
  }
  if (n.hasProperty(UserConstants.REP_PRINCIPAL_NAME)) {
    checkProtected(n.getProperty(UserConstants.REP_PRINCIPAL_NAME));
  }
  if (n.hasProperty(UserConstants.REP_IMPERSONATORS)) {
    checkProtected(n.getProperty(UserConstants.REP_IMPERSONATORS));
  }
}
