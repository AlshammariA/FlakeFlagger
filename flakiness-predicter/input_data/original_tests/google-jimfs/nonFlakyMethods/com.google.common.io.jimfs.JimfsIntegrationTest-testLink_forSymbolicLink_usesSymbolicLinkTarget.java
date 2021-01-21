@Test public void testLink_forSymbolicLink_usesSymbolicLinkTarget() throws IOException {
  Files.createFile(path("/file"));
  Files.createSymbolicLink(path("/symlink"),path("/file"));
  Object key=getFileKey("/file");
  Files.createLink(path("/link"),path("/symlink"));
  assertThat("/link").isRegularFile().and().hasLinkCount(2).and().attribute("fileKey").isEqualTo(key);
}
