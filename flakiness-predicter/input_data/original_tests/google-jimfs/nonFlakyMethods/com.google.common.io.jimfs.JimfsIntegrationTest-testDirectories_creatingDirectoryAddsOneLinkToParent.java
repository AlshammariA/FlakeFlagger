@Test public void testDirectories_creatingDirectoryAddsOneLinkToParent() throws IOException {
  Files.createDirectory(path("/foo"));
  Files.createDirectory(path("/foo/bar"));
  assertThat("/foo").hasLinkCount(3);
  Files.createDirectory(path("/foo/baz"));
  assertThat("/foo").hasLinkCount(4);
}
