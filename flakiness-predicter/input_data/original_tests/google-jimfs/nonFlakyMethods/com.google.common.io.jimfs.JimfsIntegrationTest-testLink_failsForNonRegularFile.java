@Test public void testLink_failsForNonRegularFile() throws IOException {
  Files.createDirectory(path("/dir"));
  try {
    Files.createLink(path("/link"),path("/dir"));
    fail();
  }
 catch (  FileSystemException expected) {
    assertEquals("/link",expected.getFile());
    assertEquals("/dir",expected.getOtherFile());
  }
  assertThat("/link").doesNotExist();
}
