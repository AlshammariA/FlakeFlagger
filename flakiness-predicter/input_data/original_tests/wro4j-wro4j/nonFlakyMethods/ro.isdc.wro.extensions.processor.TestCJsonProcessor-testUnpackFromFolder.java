@Test public void testUnpackFromFolder() throws Exception {
  final ResourcePostProcessor processor=new CJsonProcessor(false){
    @Override protected void onException(    final WroRuntimeException e){
      throw e;
    }
  }
;
  final URL url=getClass().getResource("cjson");
  final File testFolder=new File(url.getFile(),"pack");
  final File expectedFolder=new File(url.getFile(),"unpack");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"js",processor);
}
