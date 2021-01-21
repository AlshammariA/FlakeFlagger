@Test public void testCopy_withReplaceExisting() throws IOException {
  Files.createFile(path("/bar"));
  Files.createDirectory(path("/test"));
  assertThat("/bar").isRegularFile();
  Files.copy(path("/test"),path("/bar"),REPLACE_EXISTING);
  assertThat("/bar").isDirectory();
  byte[] bytes={0,1,2,3};
  Files.write(path("/baz"),bytes);
  Files.copy(path("/baz"),path("/bar"),REPLACE_EXISTING);
  assertThat("/bar").containsSameBytesAs("/baz");
}
