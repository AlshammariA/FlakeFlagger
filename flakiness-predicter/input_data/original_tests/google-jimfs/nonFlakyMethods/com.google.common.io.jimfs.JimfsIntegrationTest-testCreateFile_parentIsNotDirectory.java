@Test public void testCreateFile_parentIsNotDirectory() throws IOException {
  Files.createDirectory(path("/foo"));
  Files.createFile(path("/foo/bar"));
  try {
    Files.createFile(path("/foo/bar/baz"));
    fail();
  }
 catch (  NoSuchFileException expected) {
    ASSERT.that(expected.getFile()).isEqualTo("/foo/bar/baz");
  }
}
