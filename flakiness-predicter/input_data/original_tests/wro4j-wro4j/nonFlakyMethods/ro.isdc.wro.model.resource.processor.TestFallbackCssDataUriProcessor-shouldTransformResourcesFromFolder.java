@Override @Test public void shouldTransformResourcesFromFolder() throws Exception {
  final URL url=getClass().getResource("dataUri");
  final File testFolder=new File(url.getFile(),"test");
  final File expectedFolder=new File(url.getFile(),"expectedFallback");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"css",processor);
}
