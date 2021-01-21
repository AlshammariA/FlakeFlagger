@Test public void testCopy_fileToPath() throws IOException {
  byte[] bytes=preFilledBytes(512);
  Files.write(path("/foo"),bytes);
  assertThat("/bar").doesNotExist();
  Files.copy(path("/foo"),path("/bar"));
  assertThat("/bar").containsBytes(bytes);
  byte[] moreBytes=preFilledBytes(2048);
  Files.write(path("/baz"),moreBytes);
  Files.copy(path("/baz"),path("/bar"),REPLACE_EXISTING);
  assertThat("/bar").containsBytes(moreBytes);
}
