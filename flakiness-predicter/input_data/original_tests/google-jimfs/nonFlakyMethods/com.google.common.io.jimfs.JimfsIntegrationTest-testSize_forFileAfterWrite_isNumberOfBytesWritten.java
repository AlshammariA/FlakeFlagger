@Test public void testSize_forFileAfterWrite_isNumberOfBytesWritten() throws IOException {
  Files.write(path("/test"),new byte[]{0,1,2,3});
  assertThat("/test").hasSize(4);
}
