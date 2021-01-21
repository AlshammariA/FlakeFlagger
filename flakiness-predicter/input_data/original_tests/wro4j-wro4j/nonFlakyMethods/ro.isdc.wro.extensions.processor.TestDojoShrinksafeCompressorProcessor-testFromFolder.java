@Test public void testFromFolder() throws IOException {
  final ResourcePostProcessor processor=new DojoShrinksafeCompressorProcessor();
  final URL url=getClass().getResource("dojo");
  final File testFolder=new File(ClassLoader.getSystemResource("test").getFile());
  final File expectedFolder=new File(url.getFile(),"expected");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"js",processor);
}
