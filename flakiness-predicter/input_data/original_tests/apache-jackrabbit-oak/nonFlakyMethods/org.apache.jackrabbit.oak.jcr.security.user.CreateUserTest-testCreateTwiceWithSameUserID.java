public void testCreateTwiceWithSameUserID() throws RepositoryException, NotExecutableException {
  String uid=getTestPrincipal().getName();
  User user=createUser(uid,"pw");
  createdUsers.add(user);
  try {
    User user2=createUser(uid,"anyPW");
    createdUsers.add(user2);
    fail("Creating 2 users with the same UserID should throw AuthorizableExistsException.");
  }
 catch (  AuthorizableExistsException e) {
  }
}
