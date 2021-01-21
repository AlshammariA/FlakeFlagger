@Test public void testSymbolicLinks() throws IOException {
  Files.createSymbolicLink(path("/link.txt"),path("/file.txt"));
  assertThat("/link.txt",NOFOLLOW_LINKS).isSymbolicLink().withTarget("/file.txt");
  assertThat("/link.txt").doesNotExist();
  try {
    Files.createFile(path("/link.txt"));
    fail();
  }
 catch (  FileAlreadyExistsException expected) {
  }
  try {
    Files.readAllBytes(path("/link.txt"));
    fail();
  }
 catch (  NoSuchFileException expected) {
  }
  Files.createFile(path("/file.txt"));
  assertThat("/link.txt").isRegularFile();
  assertThat("/link.txt").containsNoBytes();
  Files.createSymbolicLink(path("/foo"),path("/bar/baz"));
  assertThat("/foo",NOFOLLOW_LINKS).isSymbolicLink().withTarget("/bar/baz");
  assertThat("/foo").doesNotExist();
  Files.createDirectories(path("/bar/baz"));
  assertThat("/foo").isDirectory();
  Files.createFile(path("/bar/baz/test.txt"));
  assertThat("/foo/test.txt",NOFOLLOW_LINKS).isRegularFile();
  try {
    Files.readSymbolicLink(path("/none"));
    fail();
  }
 catch (  NoSuchFileException expected) {
    assertEquals("/none",expected.getMessage());
  }
  try {
    Files.readSymbolicLink(path("/file.txt"));
    fail();
  }
 catch (  NotLinkException expected) {
    assertEquals("/file.txt",expected.getMessage());
  }
}
