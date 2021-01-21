@Test public void testIsSameFile_forPathFromDifferentFileSystemProvider() throws IOException {
  Path defaultFileSystemRoot=FileSystems.getDefault().getRootDirectories().iterator().next();
  ASSERT.that(Files.isSameFile(path("/"),defaultFileSystemRoot)).isFalse();
}
