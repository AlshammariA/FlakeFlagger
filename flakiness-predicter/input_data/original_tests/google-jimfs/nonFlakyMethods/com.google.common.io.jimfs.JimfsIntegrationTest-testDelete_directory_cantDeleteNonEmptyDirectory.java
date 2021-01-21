@Test public void testDelete_directory_cantDeleteNonEmptyDirectory() throws IOException {
  Files.createDirectories(path("/foo/bar"));
  try {
    Files.delete(path("/foo"));
    fail();
  }
 catch (  DirectoryNotEmptyException expected) {
    ASSERT.that(expected.getFile()).isEqualTo("/foo");
  }
  try {
    Files.deleteIfExists(path("/foo"));
    fail();
  }
 catch (  DirectoryNotEmptyException expected) {
    ASSERT.that(expected.getFile()).isEqualTo("/foo");
  }
}
