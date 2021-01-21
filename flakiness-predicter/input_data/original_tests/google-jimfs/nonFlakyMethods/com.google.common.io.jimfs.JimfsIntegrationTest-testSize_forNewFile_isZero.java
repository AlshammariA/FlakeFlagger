@Test public void testSize_forNewFile_isZero() throws IOException {
  Files.createFile(path("/test"));
  assertThat("/test").hasSize(0);
}
