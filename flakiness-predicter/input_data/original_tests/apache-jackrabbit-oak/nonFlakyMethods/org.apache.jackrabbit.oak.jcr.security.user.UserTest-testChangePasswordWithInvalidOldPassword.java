@Test public void testChangePasswordWithInvalidOldPassword() throws RepositoryException, NotExecutableException {
  try {
    user.changePassword("changed","wrongOldPw");
    superuser.save();
    fail("old password didn't match -> changePassword(String,String) should fail.");
  }
 catch (  RepositoryException e) {
  }
}
