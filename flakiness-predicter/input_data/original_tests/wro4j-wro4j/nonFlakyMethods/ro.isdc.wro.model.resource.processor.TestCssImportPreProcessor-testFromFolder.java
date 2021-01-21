@Test public void testFromFolder() throws Exception {
  Context.get().getConfig().setIgnoreMissingResources(false);
  final URL url=getClass().getResource("cssImport");
  final File testFolder=new File(url.getFile(),"test");
  final File expectedFolder=new File(url.getFile(),"expected");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"css",victim);
}
