@Test public void testDelete_directory() throws IOException {
  Files.createDirectories(path("/foo/bar"));
  assertThat("/foo").isDirectory();
  assertThat("/foo/bar").isDirectory();
  Files.delete(path("/foo/bar"));
  assertThat("/foo/bar").doesNotExist();
  assertTrue(Files.deleteIfExists(path("/foo")));
  assertThat("/foo").doesNotExist();
}
