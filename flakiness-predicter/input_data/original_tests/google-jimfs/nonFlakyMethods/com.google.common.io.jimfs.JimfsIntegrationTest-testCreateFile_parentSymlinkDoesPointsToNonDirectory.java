@Test public void testCreateFile_parentSymlinkDoesPointsToNonDirectory() throws IOException {
  Files.createDirectory(path("/foo"));
  Files.createFile(path("/foo/file"));
  Files.createSymbolicLink(path("/foo/bar"),path("/foo/file"));
  try {
    Files.createFile(path("/foo/bar/baz"));
    fail();
  }
 catch (  NoSuchFileException expected) {
    ASSERT.that(expected.getFile()).isEqualTo("/foo/bar/baz");
  }
}
