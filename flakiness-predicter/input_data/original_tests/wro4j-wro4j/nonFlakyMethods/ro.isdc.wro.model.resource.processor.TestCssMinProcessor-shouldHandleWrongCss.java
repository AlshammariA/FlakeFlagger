@Test public void shouldHandleWrongCss() throws Exception {
  final ResourcePostProcessor processor=new ExceptionHandlingProcessorDecorator(new CssMinProcessor());
  final URL url=getClass().getResource("cssmin");
  final File testFolder=new File(url.getFile(),"test");
  final File expectedFolder=new File(url.getFile(),"expectedInvalid");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"css",processor);
}
