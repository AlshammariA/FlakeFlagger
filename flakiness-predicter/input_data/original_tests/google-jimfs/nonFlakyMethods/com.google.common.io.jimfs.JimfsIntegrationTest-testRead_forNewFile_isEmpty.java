@Test public void testRead_forNewFile_isEmpty() throws IOException {
  Files.createFile(path("/test"));
  assertThat("/test").containsNoBytes();
}
