@Test public void testWriteFile_withStandardOptions() throws IOException {
  Path test=path("/test");
  byte[] bytes={0,1,2,3};
  try {
    Files.write(test,bytes,WRITE);
    fail();
  }
 catch (  NoSuchFileException expected) {
    assertEquals(test.toString(),expected.getMessage());
  }
  Files.write(test,bytes,CREATE_NEW);
  assertThat("/test").containsBytes(bytes);
  try {
    Files.write(test,bytes,CREATE_NEW);
    fail();
  }
 catch (  FileAlreadyExistsException expected) {
    assertEquals(test.toString(),expected.getMessage());
  }
  Files.write(test,new byte[]{4,5},CREATE);
  assertThat("/test").containsBytes(4,5,2,3);
  Files.write(test,bytes,WRITE,CREATE,TRUNCATE_EXISTING);
  assertThat("/test").containsBytes(bytes);
  Files.write(test,bytes,WRITE,APPEND);
  assertThat("/test").containsBytes(0,1,2,3,0,1,2,3);
  Files.write(test,bytes,WRITE,CREATE,TRUNCATE_EXISTING,APPEND,SPARSE,DSYNC,SYNC);
  assertThat("/test").containsBytes(bytes);
  try {
    Files.write(test,bytes,READ,WRITE);
    fail();
  }
 catch (  UnsupportedOperationException expected) {
  }
}
