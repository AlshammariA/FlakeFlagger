@Test public void testCreateFile_nonDirectoryHigherInPath() throws IOException {
  Files.createDirectory(path("/foo"));
  Files.createFile(path("/foo/bar"));
  try {
    Files.createFile(path("/foo/bar/baz/stuff"));
    fail();
  }
 catch (  NoSuchFileException expected) {
    ASSERT.that(expected.getFile()).isEqualTo("/foo/bar/baz/stuff");
  }
}
