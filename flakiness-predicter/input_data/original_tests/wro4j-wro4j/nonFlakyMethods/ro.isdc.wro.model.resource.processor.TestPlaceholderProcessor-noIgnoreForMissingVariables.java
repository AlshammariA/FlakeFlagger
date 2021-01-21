@Test(expected=WroRuntimeException.class) public void noIgnoreForMissingVariables() throws Exception {
  final ResourcePreProcessor processor=new PlaceholderProcessor().setIgnoreMissingVariables(false);
  final URL url=getClass().getResource("placeholder");
  final File testFolder=new File(url.getFile(),"test");
  final File expectedFolder=new File(url.getFile(),"expected");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"css",processor);
}
