@Test public void testCopy_directoryToPath() throws IOException {
  Files.createDirectory(path("/foo"));
  assertThat("/bar").doesNotExist();
  Files.copy(path("/foo"),path("/bar"));
  assertThat("/bar").isDirectory();
}
