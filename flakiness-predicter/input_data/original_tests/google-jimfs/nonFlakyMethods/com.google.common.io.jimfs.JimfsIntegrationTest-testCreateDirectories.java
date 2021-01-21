@Test public void testCreateDirectories() throws IOException {
  Files.createDirectories(path("/foo/bar/baz"));
  assertThat("/foo").isDirectory();
  assertThat("/foo/bar").isDirectory();
  assertThat("/foo/bar/baz").isDirectory();
  Files.createDirectories(path("/foo/asdf/jkl"));
  assertThat("/foo/asdf").isDirectory();
  assertThat("/foo/asdf/jkl").isDirectory();
  Files.createDirectories(path("bar/baz"));
  assertThat("bar/baz").isDirectory();
  assertThat("/work/bar/baz").isDirectory();
}
