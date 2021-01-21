@Test public void testMove() throws IOException {
  byte[] bytes=preFilledBytes(100);
  Files.write(path("/foo"),bytes);
  Object fooKey=getFileKey("/foo");
  Files.move(path("/foo"),path("/bar"));
  assertThat("/foo").doesNotExist().andThat("/bar").containsBytes(bytes).and().attribute("fileKey").isEqualTo(fooKey);
  Files.createDirectory(path("/foo"));
  Files.move(path("/bar"),path("/foo/bar"));
  assertThat("/bar").doesNotExist().andThat("/foo/bar").isRegularFile();
  Files.move(path("/foo"),path("/baz"));
  assertThat("/foo").doesNotExist().andThat("/baz").isDirectory().andThat("/baz/bar").isRegularFile();
}
