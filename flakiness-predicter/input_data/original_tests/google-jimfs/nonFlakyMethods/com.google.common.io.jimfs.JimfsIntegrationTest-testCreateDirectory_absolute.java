@Test public void testCreateDirectory_absolute() throws IOException {
  Files.createDirectory(path("/test"));
  assertThat("/test").exists();
  assertThat("/").hasChildren("test","work");
  Files.createDirectory(path("/foo"));
  Files.createDirectory(path("/foo/bar"));
  assertThat("/foo/bar").exists();
  assertThat("/foo").hasChildren("bar");
}
