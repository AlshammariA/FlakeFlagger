@Test public void testLink_failsWhenTargetDoesNotExist() throws IOException {
  try {
    Files.createLink(path("/link"),path("/foo"));
    fail();
  }
 catch (  NoSuchFileException expected) {
    assertEquals("/foo",expected.getFile());
  }
  Files.createSymbolicLink(path("/foo"),path("/bar"));
  try {
    Files.createLink(path("/link"),path("/foo"));
    fail();
  }
 catch (  NoSuchFileException expected) {
    assertEquals("/foo",expected.getFile());
  }
}
