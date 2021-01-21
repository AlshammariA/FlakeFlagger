@Test public void testFromFolder() throws IOException {
  final ResourcePreProcessor processor=new SemicolonAppenderPreProcessor();
  final URL url=getClass().getResource("semicolonAppender");
  final File testFolder=new File(url.getFile(),"test");
  final File expectedFolder=new File(url.getFile(),"expected");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"js",processor);
}
