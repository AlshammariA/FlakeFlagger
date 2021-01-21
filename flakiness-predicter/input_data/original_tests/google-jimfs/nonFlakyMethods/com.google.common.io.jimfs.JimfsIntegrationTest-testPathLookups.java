@Test public void testPathLookups() throws IOException {
  assertThat("/").isSameFileAs("/");
  assertThat("/..").isSameFileAs("/");
  assertThat("/../../..").isSameFileAs("/");
  assertThat("../../../..").isSameFileAs("/");
  Files.createDirectories(path("/foo/bar/baz"));
  Files.createSymbolicLink(path("/foo/bar/link1"),path("../link2"));
  Files.createSymbolicLink(path("/foo/link2"),path("/"));
  assertThat("/foo/bar/link1/foo/bar/link1/foo").isSameFileAs("/foo");
}
