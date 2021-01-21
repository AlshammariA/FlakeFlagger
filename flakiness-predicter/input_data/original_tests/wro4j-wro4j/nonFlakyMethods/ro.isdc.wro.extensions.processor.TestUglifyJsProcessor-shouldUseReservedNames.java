@Test public void shouldUseReservedNames() throws IOException {
  final ResourcePostProcessor processor=new UglifyJsProcessor(){
    @Override protected UglifyJs newEngine(){
      return super.newEngine().setReservedNames("name,value");
    }
  }
;
  final URL url=getClass().getResource("uglify");
  final File testFolder=new File(url.getFile(),"testReservedNames");
  final File expectedFolder=new File(url.getFile(),"expectedReservedNames");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"js",processor);
}
