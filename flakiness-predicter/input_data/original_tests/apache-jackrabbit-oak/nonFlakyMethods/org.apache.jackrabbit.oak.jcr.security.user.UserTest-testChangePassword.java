@Test public void testChangePassword() throws RepositoryException, NotExecutableException {
  try {
    String hash=getNode(user,superuser).getProperty(UserConstants.REP_PASSWORD).getString();
    user.changePassword("changed");
    superuser.save();
    assertFalse(hash.equals(getNode(user,superuser).getProperty(UserConstants.REP_PASSWORD).getString()));
  }
 catch (  Exception e) {
  }
}
