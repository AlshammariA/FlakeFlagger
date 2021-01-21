@Test public void testRead_forFileAfterWrite_isBytesWritten() throws IOException {
  byte[] bytes={0,1,2,3};
  Files.write(path("/test"),bytes);
  assertThat("/test").containsBytes(bytes);
}
