@Test public void testFromFolder() throws IOException {
  final ResourcePostProcessor processor=new CssCompressorProcessor();
  final URL url=getClass().getResource("cssCompressor");
  final File testFolder=new File(url.getFile(),"test");
  final File expectedFolder=new File(url.getFile(),"expected");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"css",processor);
}
