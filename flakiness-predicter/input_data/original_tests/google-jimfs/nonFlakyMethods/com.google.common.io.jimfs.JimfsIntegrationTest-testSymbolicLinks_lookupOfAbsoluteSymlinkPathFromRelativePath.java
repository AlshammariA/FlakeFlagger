@Test public void testSymbolicLinks_lookupOfAbsoluteSymlinkPathFromRelativePath() throws IOException {
  Files.createDirectories(path("/foo/bar/baz"));
  Files.createFile(path("/foo/bar/baz/file"));
  Files.createDirectories(path("one/two/three"));
  Files.createSymbolicLink(path("/work/one/two/three/link"),path("/foo/bar"));
  assertThat("one/two/three/link/baz/file").isSameFileAs("/foo/bar/baz/file");
}
