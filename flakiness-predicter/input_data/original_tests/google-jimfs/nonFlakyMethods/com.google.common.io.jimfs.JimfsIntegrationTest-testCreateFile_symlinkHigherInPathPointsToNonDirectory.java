@Test public void testCreateFile_symlinkHigherInPathPointsToNonDirectory() throws IOException {
  Files.createDirectory(path("/foo"));
  Files.createFile(path("/foo/file"));
  Files.createSymbolicLink(path("/foo/bar"),path("file"));
  try {
    Files.createFile(path("/foo/bar/baz/stuff"));
    fail();
  }
 catch (  NoSuchFileException expected) {
    ASSERT.that(expected.getFile()).isEqualTo("/foo/bar/baz/stuff");
  }
}
