@Test public void testCreateSymbolicLink_absolute() throws IOException {
  Files.createSymbolicLink(path("/link.txt"),path("test.txt"));
  assertThat("/link.txt",NOFOLLOW_LINKS).isSymbolicLink().withTarget("test.txt");
  assertThat("/").hasChildren("link.txt","work");
  Files.createDirectory(path("/foo"));
  Files.createSymbolicLink(path("/foo/link.txt"),path("test.txt"));
  assertThat("/foo/link.txt").noFollowLinks().isSymbolicLink().withTarget("test.txt");
  assertThat("/foo").hasChildren("link.txt");
}
