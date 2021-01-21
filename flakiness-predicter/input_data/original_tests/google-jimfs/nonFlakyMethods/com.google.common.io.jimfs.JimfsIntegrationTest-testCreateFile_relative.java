@Test public void testCreateFile_relative() throws IOException {
  Files.createFile(path("test.txt"));
  assertThat("/work/test.txt",NOFOLLOW_LINKS).isRegularFile();
  assertThat("test.txt",NOFOLLOW_LINKS).isRegularFile();
  assertThat("/work").hasChildren("test.txt");
  assertThat("test.txt").isSameFileAs("/work/test.txt");
  Files.createDirectory(path("foo"));
  Files.createFile(path("foo/test.txt"));
  assertThat("/work/foo/test.txt",NOFOLLOW_LINKS).isRegularFile();
  assertThat("foo/test.txt",NOFOLLOW_LINKS).isRegularFile();
  assertThat("/work/foo").hasChildren("test.txt");
  assertThat("foo").hasChildren("test.txt");
  assertThat("foo/test.txt").isSameFileAs("/work/foo/test.txt");
}
