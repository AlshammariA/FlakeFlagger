@Test public void testCreateFile_symlinkHigherInPathDoesNotExist() throws IOException {
  Files.createDirectory(path("/foo"));
  Files.createSymbolicLink(path("/foo/bar"),path("nope"));
  try {
    Files.createFile(path("/foo/bar/baz/stuff"));
    fail();
  }
 catch (  NoSuchFileException expected) {
    ASSERT.that(expected.getFile()).isEqualTo("/foo/bar/baz/stuff");
  }
}
