@Test public void testCopy_withReplaceExisting_cantReplaceNonEmptyDirectory() throws IOException {
  Files.createDirectory(path("/foo"));
  Files.createDirectory(path("/foo/bar"));
  Files.createFile(path("/foo/baz"));
  Files.createDirectory(path("/test"));
  try {
    Files.copy(path("/test"),path("/foo"),REPLACE_EXISTING);
    fail();
  }
 catch (  DirectoryNotEmptyException expected) {
    assertEquals("/foo",expected.getMessage());
  }
  Files.delete(path("/test"));
  Files.createFile(path("/test"));
  try {
    Files.copy(path("/test"),path("/foo"),REPLACE_EXISTING);
    fail();
  }
 catch (  DirectoryNotEmptyException expected) {
    assertEquals("/foo",expected.getMessage());
  }
  Files.delete(path("/foo/baz"));
  Files.delete(path("/foo/bar"));
  Files.copy(path("/test"),path("/foo"),REPLACE_EXISTING);
  assertThat("/foo").isRegularFile();
}
