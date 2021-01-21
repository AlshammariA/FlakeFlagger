@Test public void testCopy_inputStreamToFile() throws IOException {
  byte[] bytes=preFilledBytes(512);
  Files.copy(new ByteArrayInputStream(bytes),path("/test"));
  assertThat("/test").containsBytes(bytes);
  try {
    Files.copy(new ByteArrayInputStream(bytes),path("/test"));
    fail();
  }
 catch (  FileAlreadyExistsException expected) {
    assertEquals("/test",expected.getMessage());
  }
  Files.copy(new ByteArrayInputStream(bytes),path("/test"),REPLACE_EXISTING);
  assertThat("/test").containsBytes(bytes);
  Files.copy(new ByteArrayInputStream(bytes),path("/foo"),REPLACE_EXISTING);
  assertThat("/foo").containsBytes(bytes);
}
