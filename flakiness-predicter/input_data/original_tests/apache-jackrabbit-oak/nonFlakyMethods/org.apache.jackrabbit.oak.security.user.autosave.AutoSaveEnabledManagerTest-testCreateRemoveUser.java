@Test public void testCreateRemoveUser() throws RepositoryException {
  User u=mgr.createUser("u","u");
  assertFalse(root.hasPendingChanges());
  u.remove();
  assertFalse(root.hasPendingChanges());
}
