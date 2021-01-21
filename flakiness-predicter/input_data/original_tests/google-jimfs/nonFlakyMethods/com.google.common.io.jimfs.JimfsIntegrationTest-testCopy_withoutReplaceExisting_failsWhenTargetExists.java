@Test public void testCopy_withoutReplaceExisting_failsWhenTargetExists() throws IOException {
  Files.createFile(path("/bar"));
  Files.createDirectory(path("/foo"));
  try {
    Files.copy(path("/foo"),path("/bar"));
    fail();
  }
 catch (  FileAlreadyExistsException expected) {
    assertEquals("/bar",expected.getMessage());
  }
  Files.delete(path("/foo"));
  Files.createFile(path("/foo"));
  try {
    Files.copy(path("/foo"),path("/bar"));
    fail();
  }
 catch (  FileAlreadyExistsException expected) {
    assertEquals("/bar",expected.getMessage());
  }
  Files.delete(path("/bar"));
  Files.createDirectory(path("/bar"));
  try {
    Files.copy(path("/foo"),path("/bar"));
    fail();
  }
 catch (  FileAlreadyExistsException expected) {
    assertEquals("/bar",expected.getMessage());
  }
  Files.delete(path("/foo"));
  Files.createDirectory(path("/foo"));
  try {
    Files.copy(path("/foo"),path("/bar"));
    fail();
  }
 catch (  FileAlreadyExistsException expected) {
    assertEquals("/bar",expected.getMessage());
  }
}
