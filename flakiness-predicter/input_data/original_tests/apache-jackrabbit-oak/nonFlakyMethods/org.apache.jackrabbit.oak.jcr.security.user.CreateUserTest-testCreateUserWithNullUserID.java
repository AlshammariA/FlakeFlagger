@Test public void testCreateUserWithNullUserID() throws RepositoryException {
  try {
    User user=createUser(null,"anyPW");
    createdUsers.add(user);
    fail("A User cannot be built with 'null' userID");
  }
 catch (  Exception e) {
  }
}
