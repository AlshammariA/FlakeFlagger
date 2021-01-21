@Test public void testDirectories_newlyCreatedDirectoryHasTwoLinks() throws IOException {
  Files.createDirectory(path("/foo"));
  assertThat("/foo").hasLinkCount(2);
}
