@Test public void testAutoSaveEnabled() throws RepositoryException {
  assertTrue(mgr instanceof AutoSaveEnabledManager);
  assertTrue(mgr.isAutoSave());
  mgr.autoSave(false);
  assertFalse(mgr.isAutoSave());
  mgr.autoSave(true);
}
