@Test public void testCopyNoWritePermissionAtTarget() throws Exception {
  try {
    testSession.getWorkspace().copy(path,destPath);
    fail("no write permission at copy target");
  }
 catch (  AccessDeniedException e) {
  }
}
