@Test public void testAutoSave() throws Exception {
  try {
    userMgr.autoSave(true);
    fail("should fail");
  }
 catch (  UnsupportedRepositoryOperationException e) {
  }
}
