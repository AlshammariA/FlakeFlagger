@Test public void testWrite_fileExistsButIsNotRegularFile() throws IOException {
  Files.createDirectory(path("/foo"));
  try {
    Files.write(path("/foo"),preFilledBytes(10),WRITE);
  }
 catch (  FileSystemException expected) {
    ASSERT.that(expected.getFile()).isEqualTo("/foo");
    ASSERT.that(expected.getMessage()).contains("regular file");
  }
  try {
    Files.write(path("/foo"),preFilledBytes(10));
  }
 catch (  FileSystemException expected) {
    ASSERT.that(expected.getFile()).isEqualTo("/foo");
    ASSERT.that(expected.getMessage()).contains("regular file");
  }
}
