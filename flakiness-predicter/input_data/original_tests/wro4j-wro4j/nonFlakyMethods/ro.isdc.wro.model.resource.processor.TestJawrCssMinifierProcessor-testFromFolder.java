@Test public void testFromFolder() throws IOException {
  final ResourcePostProcessor processor=new JawrCssMinifierProcessor();
  final URL url=getClass().getResource("jawrcss");
  final File testFolder=new File(url.getFile(),"test");
  final File expectedFolder=new File(url.getFile(),"expected");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"css",processor);
}
