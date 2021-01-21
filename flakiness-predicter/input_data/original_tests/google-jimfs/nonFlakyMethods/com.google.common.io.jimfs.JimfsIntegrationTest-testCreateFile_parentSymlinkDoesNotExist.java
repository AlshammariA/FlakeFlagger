@Test public void testCreateFile_parentSymlinkDoesNotExist() throws IOException {
  Files.createDirectory(path("/foo"));
  Files.createSymbolicLink(path("/foo/bar"),path("/foo/nope"));
  try {
    Files.createFile(path("/foo/bar/baz"));
    fail();
  }
 catch (  NoSuchFileException expected) {
    ASSERT.that(expected.getFile()).isEqualTo("/foo/bar/baz");
  }
}
