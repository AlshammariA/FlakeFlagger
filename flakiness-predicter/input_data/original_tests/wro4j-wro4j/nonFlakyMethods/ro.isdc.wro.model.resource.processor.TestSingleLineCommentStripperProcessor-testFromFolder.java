@Test public void testFromFolder() throws IOException {
  final ResourcePostProcessor processor=new SingleLineCommentStripperProcessor();
  final URL url=getClass().getResource("singleLine");
  final File testFolder=new File(url.getFile(),"test");
  final File expectedFolder=new File(url.getFile(),"expected");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"js",processor);
}
