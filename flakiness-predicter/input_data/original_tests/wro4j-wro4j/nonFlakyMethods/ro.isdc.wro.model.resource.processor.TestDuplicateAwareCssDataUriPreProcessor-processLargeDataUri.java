/** 
 * Check if a large dataUri with more than 32KB does not replace original url.
 */
@Test public void processLargeDataUri() throws Exception {
  final URL url=getClass().getResource("duplicateAwareDataUri");
  final File testFolder=new File(url.getFile(),"test");
  final File expectedFolder=new File(url.getFile(),"expected");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"css",WroUtil.newResourceProcessor(createMockResource("file:" + testFolder.getPath() + "/test.css"),processor));
}
