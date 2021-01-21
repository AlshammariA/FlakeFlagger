@Test public void testPackFromFolder() throws Exception {
  final ResourcePostProcessor processor=new CJsonProcessor(true){
    @Override protected void onException(    final WroRuntimeException e){
      throw e;
    }
  }
;
  final URL url=getClass().getResource("cjson");
  final File testFolder=new File(url.getFile(),"test");
  final File expectedFolder=new File(url.getFile(),"pack");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"js",processor);
}
