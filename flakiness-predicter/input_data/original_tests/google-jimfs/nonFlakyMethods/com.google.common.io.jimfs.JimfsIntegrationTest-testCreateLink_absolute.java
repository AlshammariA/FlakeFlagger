@Test public void testCreateLink_absolute() throws IOException {
  Files.createFile(path("/test.txt"));
  Files.createLink(path("/link.txt"),path("/test.txt"));
  assertThat("/link.txt",NOFOLLOW_LINKS).isRegularFile();
  assertThat("/").hasChildren("link.txt","test.txt","work");
  Files.createDirectory(path("/foo"));
  Files.createLink(path("/foo/link.txt"),path("/test.txt"));
  assertThat("/foo/link.txt",NOFOLLOW_LINKS).isRegularFile();
  assertThat("/foo").hasChildren("link.txt");
}
