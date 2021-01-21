@Test public void testProtectedGroupProperties() throws NotExecutableException, RepositoryException {
  Node n=getNode(group,superuser);
  if (n.hasProperty(UserConstants.REP_PRINCIPAL_NAME)) {
    checkProtected(n.getProperty(UserConstants.REP_PRINCIPAL_NAME));
  }
  if (n.hasProperty(UserConstants.REP_MEMBERS)) {
    checkProtected(n.getProperty(UserConstants.REP_MEMBERS));
  }
}
