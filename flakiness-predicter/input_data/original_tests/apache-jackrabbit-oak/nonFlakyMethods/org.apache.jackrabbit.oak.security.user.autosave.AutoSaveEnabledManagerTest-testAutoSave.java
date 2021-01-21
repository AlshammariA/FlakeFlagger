@Test public void testAutoSave() throws RepositoryException {
  mgr.autoSave(false);
  mgr.autoSave(true);
}
