@Test public void testDisable() throws NotExecutableException, RepositoryException {
  try {
    admin.disable("-> out");
    superuser.save();
    fail("The admin cannot be disabled");
  }
 catch (  RepositoryException e) {
  }
}
