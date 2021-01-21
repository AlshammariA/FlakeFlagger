@Test public void testCreateDirectory_relative() throws IOException {
  Files.createDirectory(path("test"));
  assertThat("/work/test",NOFOLLOW_LINKS).isDirectory();
  assertThat("test",NOFOLLOW_LINKS).isDirectory();
  assertThat("/work").hasChildren("test");
  assertThat("test").isSameFileAs("/work/test");
  Files.createDirectory(path("foo"));
  Files.createDirectory(path("foo/bar"));
  assertThat("/work/foo/bar",NOFOLLOW_LINKS).isDirectory();
  assertThat("foo/bar",NOFOLLOW_LINKS).isDirectory();
  assertThat("/work/foo").hasChildren("bar");
  assertThat("foo").hasChildren("bar");
  assertThat("foo/bar").isSameFileAs("/work/foo/bar");
}
