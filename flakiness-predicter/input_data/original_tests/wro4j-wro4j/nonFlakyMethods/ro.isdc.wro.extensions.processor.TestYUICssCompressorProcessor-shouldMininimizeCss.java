@Test public void shouldMininimizeCss() throws IOException {
  final URL url=getClass().getResource("yui");
  final File testFolder=new File(url.getFile(),"test");
  final File expectedFolder=new File(url.getFile(),"expected");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"css",victim);
}
