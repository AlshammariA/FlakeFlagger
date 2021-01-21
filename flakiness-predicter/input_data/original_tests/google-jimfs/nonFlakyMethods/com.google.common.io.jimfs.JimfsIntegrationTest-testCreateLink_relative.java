@Test public void testCreateLink_relative() throws IOException {
  Files.createFile(path("test.txt"));
  Files.createLink(path("link.txt"),path("test.txt"));
  assertThat("/work/link.txt",NOFOLLOW_LINKS).isRegularFile();
  assertThat("link.txt",NOFOLLOW_LINKS).isRegularFile();
  assertThat("/work").hasChildren("link.txt","test.txt");
  Files.createDirectory(path("foo"));
  Files.createLink(path("foo/link.txt"),path("test.txt"));
  assertThat("/work/foo/link.txt",NOFOLLOW_LINKS).isRegularFile();
  assertThat("foo/link.txt",NOFOLLOW_LINKS).isRegularFile();
  assertThat("foo").hasChildren("link.txt");
}
