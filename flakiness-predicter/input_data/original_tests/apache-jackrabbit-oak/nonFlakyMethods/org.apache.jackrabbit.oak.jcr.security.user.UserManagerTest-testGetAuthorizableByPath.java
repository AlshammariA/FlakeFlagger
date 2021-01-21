@Test public void testGetAuthorizableByPath() throws RepositoryException, NotExecutableException {
  String uid=superuser.getUserID();
  Authorizable a=userMgr.getAuthorizable(uid);
  if (a == null) {
    throw new NotExecutableException();
  }
  try {
    String path=a.getPath();
    Authorizable a2=userMgr.getAuthorizableByPath(path);
    assertNotNull(a2);
    assertEquals(a.getID(),a2.getID());
  }
 catch (  UnsupportedRepositoryOperationException e) {
    throw new NotExecutableException();
  }
}
