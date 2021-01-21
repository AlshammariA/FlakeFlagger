@Test public void testLoginAfterChangePassword() throws RepositoryException {
  user.changePassword("changed");
  superuser.save();
  Session s=getHelper().getRepository().login(new SimpleCredentials(user.getID(),"changed".toCharArray()));
  s.logout();
}
