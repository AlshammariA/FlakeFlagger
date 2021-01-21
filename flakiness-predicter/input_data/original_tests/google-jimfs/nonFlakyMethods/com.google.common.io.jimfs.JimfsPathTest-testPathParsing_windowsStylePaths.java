@Test public void testPathParsing_windowsStylePaths() throws IOException {
  fs=(JimfsFileSystem)Jimfs.newWindowsLikeFileSystem();
  assertEquals("C:",fs.getPath("C:").toString());
  assertEquals("C:\\foo",fs.getPath("C:\\foo").toString());
  assertEquals("C:\\foo",fs.getPath("C:\\","foo").toString());
  assertEquals("C:\\foo",fs.getPath("C:","\\foo").toString());
  assertEquals("C:\\foo",fs.getPath("C:","foo").toString());
  assertEquals("C:\\foo\\bar",fs.getPath("C:","foo/bar").toString());
}
