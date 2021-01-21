@Test public void testCreateSymbolicLink_relative() throws IOException {
  Files.createSymbolicLink(path("link.txt"),path("test.txt"));
  assertThat("/work/link.txt",NOFOLLOW_LINKS).isSymbolicLink().withTarget("test.txt");
  assertThat("link.txt",NOFOLLOW_LINKS).isSymbolicLink().withTarget("test.txt");
  assertThat("/work").hasChildren("link.txt");
  Files.createDirectory(path("foo"));
  Files.createSymbolicLink(path("foo/link.txt"),path("test.txt"));
  assertThat("/work/foo/link.txt",NOFOLLOW_LINKS).isSymbolicLink().withTarget("test.txt");
  assertThat("foo/link.txt",NOFOLLOW_LINKS).isSymbolicLink().withTarget("test.txt");
  assertThat("/work/foo").hasChildren("link.txt");
  assertThat("foo").hasChildren("link.txt");
}
