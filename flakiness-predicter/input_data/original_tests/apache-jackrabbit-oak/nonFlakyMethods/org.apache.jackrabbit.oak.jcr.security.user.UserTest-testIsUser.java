@Test public void testIsUser() throws RepositoryException {
  Authorizable authorizable=userMgr.getAuthorizable(user.getID());
  assertTrue(authorizable instanceof User);
}
