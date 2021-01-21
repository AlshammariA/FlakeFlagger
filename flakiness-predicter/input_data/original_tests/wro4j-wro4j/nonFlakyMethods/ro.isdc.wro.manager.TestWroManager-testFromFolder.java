/** 
 * Ignored because it fails when running the test from command line.
 */
@Test public void testFromFolder() throws Exception {
  final ResourcePreProcessor processor=new WroManagerProcessor();
  final URL url=getClass().getResource("wroManager");
  final File testFolder=new File(url.getFile(),"test");
  final File expectedFolder=new File(url.getFile(),"expected");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"js",processor);
}
