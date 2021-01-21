@Test public void testFromFolder() throws IOException {
  final URL url=getClass().getResource("sasscss");
  final ResourcePostProcessor processor=new SassCssProcessor();
  final File testFolder=new File(url.getFile(),"test");
  final File expectedFolder=new File(url.getFile(),"expected");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"css",processor);
}
