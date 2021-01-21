@Test public void testCreateUserWithRelativePath() throws RepositoryException, NotExecutableException {
  Principal p=getTestPrincipal();
  String uid=p.getName();
  User user=createUser(uid,"pw",p,"any/path");
  createdUsers.add(user);
  assertNotNull(user.getID());
  assertTrue(user.getPath().contains("any/path"));
}
