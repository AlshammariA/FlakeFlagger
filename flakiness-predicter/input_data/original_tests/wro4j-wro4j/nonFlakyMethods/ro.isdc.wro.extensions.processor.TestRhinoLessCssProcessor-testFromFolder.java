@Test public void testFromFolder() throws Exception {
  final ResourcePreProcessor processor=new RhinoLessCssProcessor();
  final URL url=getClass().getResource("lesscss");
  final File testFolder=new File(url.getFile(),"test");
  final File expectedFolder=new File(url.getFile(),"expected");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"css",processor);
}
