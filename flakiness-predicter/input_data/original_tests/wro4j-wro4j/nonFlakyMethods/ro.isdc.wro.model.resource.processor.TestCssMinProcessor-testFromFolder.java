@Test public void testFromFolder() throws Exception {
  final ResourcePostProcessor processor=new CssMinProcessor();
  final URL url=getClass().getResource("cssmin");
  final File testFolder=new File(url.getFile(),"test");
  final File expectedFolder=new File(url.getFile(),"expected");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"css",processor);
}
