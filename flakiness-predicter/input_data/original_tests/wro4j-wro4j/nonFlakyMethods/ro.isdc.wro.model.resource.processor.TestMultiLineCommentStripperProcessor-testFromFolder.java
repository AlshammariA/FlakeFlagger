@Test public void testFromFolder() throws IOException {
  final ResourcePostProcessor processor=new MultiLineCommentStripperProcessor();
  final URL url=getClass().getResource("multiline");
  final File testFolder=new File(url.getFile(),"test");
  final File expectedFolder=new File(url.getFile(),"expected");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"*",processor);
}
