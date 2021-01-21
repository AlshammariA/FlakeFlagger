@Test public void testSymbolicLinks_symlinkCycle() throws IOException {
  Files.createDirectory(path("/foo"));
  Files.createSymbolicLink(path("/foo/bar"),path("baz"));
  Files.createSymbolicLink(path("/foo/baz"),path("bar"));
  try {
    Files.createFile(path("/foo/bar/file"));
    fail();
  }
 catch (  IOException expected) {
    ASSERT.that(expected.getMessage()).contains("symbolic link");
  }
  try {
    Files.write(path("/foo/bar"),preFilledBytes(10));
    fail();
  }
 catch (  IOException expected) {
    ASSERT.that(expected.getMessage()).contains("symbolic link");
  }
}
