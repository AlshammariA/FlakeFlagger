@Test public void testIsSameFile() throws IOException {
  Files.createDirectory(path("/foo"));
  Files.createSymbolicLink(path("/bar"),path("/foo"));
  Files.createFile(path("/bar/test"));
  assertThat("/foo").isSameFileAs("/foo");
  assertThat("/bar").isSameFileAs("/bar");
  assertThat("/foo/test").isSameFileAs("/foo/test");
  assertThat("/bar/test").isSameFileAs("/bar/test");
  assertThat("/foo").isNotSameFileAs("test");
  assertThat("/bar").isNotSameFileAs("/test");
  assertThat("/foo").isSameFileAs("/bar");
  assertThat("/foo/test").isSameFileAs("/bar/test");
  Files.createSymbolicLink(path("/baz"),path("bar"));
  assertThat("/baz").isSameFileAs("/foo");
  assertThat("/baz/test").isSameFileAs("/foo/test");
}
