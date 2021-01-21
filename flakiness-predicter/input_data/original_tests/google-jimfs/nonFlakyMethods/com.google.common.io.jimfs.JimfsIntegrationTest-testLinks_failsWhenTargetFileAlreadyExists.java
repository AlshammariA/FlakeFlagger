@Test public void testLinks_failsWhenTargetFileAlreadyExists() throws IOException {
  Files.createFile(path("/file"));
  Files.createFile(path("/link"));
  try {
    Files.createLink(path("/link"),path("/file"));
    fail();
  }
 catch (  FileAlreadyExistsException expected) {
    assertEquals("/link",expected.getFile());
  }
}
