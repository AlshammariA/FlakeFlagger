@Test public void testMove_cannotMoveDirIntoOwnSubtree() throws IOException {
  Files.createDirectories(path("/foo"));
  try {
    Files.move(path("/foo"),path("/foo/bar"));
    fail();
  }
 catch (  IOException expected) {
    ASSERT.that(expected.getMessage()).contains("sub");
  }
  Files.createDirectories(path("/foo/bar/baz/stuff"));
  Files.createDirectories(path("/hello/world"));
  Files.createSymbolicLink(path("/hello/world/link"),path("../../foo/bar/baz"));
  try {
    Files.move(path("/foo/bar"),path("/hello/world/link/bar"));
    fail();
  }
 catch (  IOException expected) {
    ASSERT.that(expected.getMessage()).contains("sub");
  }
}
