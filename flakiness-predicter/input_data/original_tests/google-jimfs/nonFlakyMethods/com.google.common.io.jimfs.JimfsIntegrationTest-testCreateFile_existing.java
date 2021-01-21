@Test public void testCreateFile_existing() throws IOException {
  Files.createFile(path("/test"));
  try {
    Files.createFile(path("/test"));
    fail();
  }
 catch (  FileAlreadyExistsException expected) {
    assertEquals("/test",expected.getMessage());
  }
  try {
    Files.createDirectory(path("/test"));
    fail();
  }
 catch (  FileAlreadyExistsException expected) {
    assertEquals("/test",expected.getMessage());
  }
  try {
    Files.createSymbolicLink(path("/test"),path("/foo"));
    fail();
  }
 catch (  FileAlreadyExistsException expected) {
    assertEquals("/test",expected.getMessage());
  }
  Files.createFile(path("/foo"));
  try {
    Files.createLink(path("/test"),path("/foo"));
    fail();
  }
 catch (  FileAlreadyExistsException expected) {
    assertEquals("/test",expected.getMessage());
  }
}
