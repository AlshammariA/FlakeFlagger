@Test public void testChangePasswordWithOldPassword() throws RepositoryException, NotExecutableException {
  try {
    String hash=getNode(user,superuser).getProperty(UserConstants.REP_PASSWORD).getString();
    user.changePassword("changed",testPw);
    superuser.save();
    assertFalse(hash.equals(getNode(user,superuser).getProperty(UserConstants.REP_PASSWORD).getString()));
  }
  finally {
    user.changePassword(testPw);
    superuser.save();
  }
}
