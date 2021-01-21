@Test public void testCreateRemoveGroup() throws RepositoryException {
  Group g=mgr.createGroup("g");
  assertFalse(root.hasPendingChanges());
  g.remove();
  assertFalse(root.hasPendingChanges());
}
