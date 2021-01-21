@Test public void testCopy_symbolicLinkToPath() throws IOException {
  byte[] bytes=preFilledBytes(128);
  Files.write(path("/test"),bytes);
  Files.createSymbolicLink(path("/link"),path("/test"));
  assertThat("/bar").doesNotExist();
  Files.copy(path("/link"),path("/bar"));
  assertThat("/bar",NOFOLLOW_LINKS).containsBytes(bytes);
  Files.delete(path("/bar"));
  Files.copy(path("/link"),path("/bar"),NOFOLLOW_LINKS);
  assertThat("/bar",NOFOLLOW_LINKS).isSymbolicLink().withTarget("/test");
  assertThat("/bar").isRegularFile();
  assertThat("/bar").containsBytes(bytes);
  Files.delete(path("/test"));
  assertThat("/bar",NOFOLLOW_LINKS).isSymbolicLink();
  assertThat("/bar").doesNotExist();
}
