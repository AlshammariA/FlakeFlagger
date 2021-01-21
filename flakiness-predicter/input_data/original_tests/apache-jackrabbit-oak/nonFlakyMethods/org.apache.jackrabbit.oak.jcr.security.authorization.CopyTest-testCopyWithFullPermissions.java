@Test public void testCopyWithFullPermissions() throws Exception {
  allow(targetPath,privilegesFromName(Privilege.JCR_ALL));
  testSession.getWorkspace().copy(path,destPath);
  assertTrue(testSession.nodeExists(destPath));
}
