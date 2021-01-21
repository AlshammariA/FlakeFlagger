@Test public void testFromFolder() throws IOException {
  final ResourcePostProcessor processor=new BeautifyJsProcessor();
  final URL url=getClass().getResource("beautify");
  final File testFolder=new File(url.getFile(),"test");
  final File expectedFolder=new File(url.getFile(),"expected");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"js",processor);
}
