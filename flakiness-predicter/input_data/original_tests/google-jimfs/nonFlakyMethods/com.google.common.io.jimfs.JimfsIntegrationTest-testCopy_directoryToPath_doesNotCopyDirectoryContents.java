@Test public void testCopy_directoryToPath_doesNotCopyDirectoryContents() throws IOException {
  Files.createDirectory(path("/foo"));
  Files.createDirectory(path("/foo/baz"));
  Files.createFile(path("/foo/test"));
  Files.copy(path("/foo"),path("/bar"));
  assertThat("/bar").hasNoChildren();
}
