@Test public void testRemoveAdmin() throws NotExecutableException {
  try {
    admin.remove();
    superuser.save();
    fail("The admin user cannot be removed.");
  }
 catch (  RepositoryException e) {
  }
}
