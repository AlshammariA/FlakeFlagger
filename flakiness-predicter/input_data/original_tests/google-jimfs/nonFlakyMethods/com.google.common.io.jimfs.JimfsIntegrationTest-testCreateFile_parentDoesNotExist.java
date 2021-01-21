@Test public void testCreateFile_parentDoesNotExist() throws IOException {
  try {
    Files.createFile(path("/foo/test"));
    fail();
  }
 catch (  NoSuchFileException expected) {
    assertEquals("/foo/test",expected.getMessage());
  }
  try {
    Files.createDirectory(path("/foo/test"));
    fail();
  }
 catch (  NoSuchFileException expected) {
    assertEquals("/foo/test",expected.getMessage());
  }
  try {
    Files.createSymbolicLink(path("/foo/test"),path("/bar"));
    fail();
  }
 catch (  NoSuchFileException expected) {
    assertEquals("/foo/test",expected.getMessage());
  }
  Files.createFile(path("/bar"));
  try {
    Files.createLink(path("/foo/test"),path("/bar"));
    fail();
  }
 catch (  NoSuchFileException expected) {
    assertEquals("/foo/test",expected.getMessage());
  }
}
