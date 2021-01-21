@Test public void testCommitFailedRevertChanges() throws RepositoryException {
  User u=mgr.createUser("u","u");
  try {
    User u2=mgr.createUser("u","u");
    fail();
  }
 catch (  RepositoryException e) {
    assertFalse(root.hasPendingChanges());
  }
}
