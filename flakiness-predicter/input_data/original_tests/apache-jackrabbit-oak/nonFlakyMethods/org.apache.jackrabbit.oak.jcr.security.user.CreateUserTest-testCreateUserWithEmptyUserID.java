@Test public void testCreateUserWithEmptyUserID() throws RepositoryException {
  try {
    User user=createUser("","anyPW");
    createdUsers.add(user);
    fail("A User cannot be built with \"\" userID");
  }
 catch (  Exception e) {
  }
  try {
    User user=createUser("","anyPW",getTestPrincipal(),null);
    createdUsers.add(user);
    fail("A User cannot be built with \"\" userID");
  }
 catch (  Exception e) {
  }
}
