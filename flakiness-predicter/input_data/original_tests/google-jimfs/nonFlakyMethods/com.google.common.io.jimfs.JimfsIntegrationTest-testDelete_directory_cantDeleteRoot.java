@Test public void testDelete_directory_cantDeleteRoot() throws IOException {
  Files.delete(path("/work"));
  try {
    Files.delete(path("/"));
    fail();
  }
 catch (  IOException expected) {
    ASSERT.that(expected.getMessage()).contains("root");
  }
  Files.createDirectories(path("/foo/bar"));
  try {
    Files.delete(path("/foo/bar/../.."));
    fail();
  }
 catch (  IOException expected) {
    ASSERT.that(expected.getMessage()).contains("root");
  }
  try {
    Files.delete(path("/foo/./../foo/bar/./../bar/.././../../.."));
    fail();
  }
 catch (  IOException expected) {
    ASSERT.that(expected.getMessage()).contains("root");
  }
}
