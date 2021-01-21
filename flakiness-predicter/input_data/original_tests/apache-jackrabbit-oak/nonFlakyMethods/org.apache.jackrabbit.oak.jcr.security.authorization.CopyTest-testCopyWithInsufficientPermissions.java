@Test public void testCopyWithInsufficientPermissions() throws Exception {
  allow(targetPath,privilegesFromName(Privilege.JCR_ADD_CHILD_NODES));
  try {
    testSession.getWorkspace().copy(path,destPath);
    fail("insufficient write permission at copy target");
  }
 catch (  AccessDeniedException e) {
  }
}
