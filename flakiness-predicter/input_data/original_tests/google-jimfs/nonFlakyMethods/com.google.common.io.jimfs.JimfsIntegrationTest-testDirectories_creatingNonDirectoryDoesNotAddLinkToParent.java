@Test public void testDirectories_creatingNonDirectoryDoesNotAddLinkToParent() throws IOException {
  Files.createDirectory(path("/foo"));
  Files.createFile(path("/foo/file"));
  Files.createSymbolicLink(path("/foo/fileSymlink"),path("file"));
  Files.createLink(path("/foo/link"),path("/foo/file"));
  Files.createSymbolicLink(path("/foo/fooSymlink"),path("/foo"));
  assertThat("/foo").hasLinkCount(2);
}
