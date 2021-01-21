@Test public void testDelete_file() throws IOException {
  try {
    Files.delete(path("/test"));
    fail();
  }
 catch (  NoSuchFileException expected) {
    assertEquals("/test",expected.getMessage());
  }
  try {
    Files.delete(path("/foo/bar"));
    fail();
  }
 catch (  NoSuchFileException expected) {
    assertEquals("/foo/bar",expected.getMessage());
  }
  assertFalse(Files.deleteIfExists(path("/test")));
  assertFalse(Files.deleteIfExists(path("/foo/bar")));
  Files.createFile(path("/test"));
  assertThat("/test").isRegularFile();
  Files.delete(path("/test"));
  assertThat("/test").doesNotExist();
  Files.createFile(path("/test"));
  assertTrue(Files.deleteIfExists(path("/test")));
  assertThat("/test").doesNotExist();
}
