@Test public void testCreateUserWithNullParamerters() throws RepositoryException {
  try {
    User user=createUser(null,null);
    createdUsers.add(user);
    fail("A User cannot be built from 'null' parameters");
  }
 catch (  Exception e) {
  }
  try {
    User user=createUser(null,null,null,null);
    createdUsers.add(user);
    fail("A User cannot be built from 'null' parameters");
  }
 catch (  Exception e) {
  }
}
