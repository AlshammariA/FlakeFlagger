@Test public void shouldTransformFilesFromFolder() throws IOException {
  final URL url=getClass().getResource("handlebarsjs");
  final File testFolder=new File(url.getFile(),"test");
  final File expectedFolder=new File(url.getFile(),"expected");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"handlebars",processor);
}
