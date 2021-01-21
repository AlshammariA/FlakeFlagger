@Test public void testCreateFile_absolute() throws IOException {
  Files.createFile(path("/test.txt"));
  assertThat("/test.txt").isRegularFile();
  assertThat("/").hasChildren("test.txt","work");
  Files.createDirectory(path("/foo"));
  Files.createFile(path("/foo/test.txt"));
  assertThat("/foo/test.txt").isRegularFile();
  assertThat("/foo").hasChildren("test.txt");
}
