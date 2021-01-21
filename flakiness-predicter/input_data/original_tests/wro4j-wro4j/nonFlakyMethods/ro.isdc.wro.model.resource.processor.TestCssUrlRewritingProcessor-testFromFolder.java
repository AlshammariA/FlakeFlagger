@Test public void testFromFolder() throws Exception {
  final URL url=getClass().getResource("cssUrlRewriting");
  final File testFolder=new File(url.getFile(),"test");
  final File expectedFolder=new File(url.getFile(),"expected");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"css",(ResourcePreProcessor)processor);
}
