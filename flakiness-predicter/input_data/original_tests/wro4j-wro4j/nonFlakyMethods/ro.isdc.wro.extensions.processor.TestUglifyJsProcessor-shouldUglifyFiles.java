@Test public void shouldUglifyFiles() throws IOException {
  final ResourcePostProcessor processor=new UglifyJsProcessor();
  final URL url=getClass().getResource("uglify");
  final File expectedFolder=new File(url.getFile(),"expected");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"js",processor);
}
