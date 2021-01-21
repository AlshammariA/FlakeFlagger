@Test public void testChangePasswordNull() throws RepositoryException, NotExecutableException {
  try {
    user.changePassword(null);
    superuser.save();
    fail("invalid pw null");
  }
 catch (  Exception e) {
  }
}
