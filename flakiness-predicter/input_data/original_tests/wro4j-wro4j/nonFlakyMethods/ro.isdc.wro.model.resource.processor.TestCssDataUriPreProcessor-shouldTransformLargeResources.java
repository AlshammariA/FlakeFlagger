@Test public void shouldTransformLargeResources() throws Exception {
  processor=new CssDataUriPreProcessor();
  initProcessor(processor);
  final URL url=getClass().getResource("dataUri");
  final File testFolder=new File(url.getFile(),"test");
  final File expectedFolder=new File(url.getFile(),"expectedLarge");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"css",processor);
}
