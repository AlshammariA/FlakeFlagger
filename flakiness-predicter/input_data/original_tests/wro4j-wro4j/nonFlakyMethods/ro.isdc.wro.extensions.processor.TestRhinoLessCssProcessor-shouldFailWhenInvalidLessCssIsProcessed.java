/** 
 * Test that processing invalid less css produces exceptions
 */
@Test public void shouldFailWhenInvalidLessCssIsProcessed() throws Exception {
  final ResourcePreProcessor processor=new RhinoLessCssProcessor(){
    @Override protected void onException(    final WroRuntimeException e){
      LOG.debug("[FAIL] Exception message is: {}",e.getMessage());
      throw e;
    }
  }
;
  final URL url=getClass().getResource("lesscss");
  final File testFolder=new File(url.getFile(),"invalid");
  WroTestUtils.forEachFileInFolder(testFolder,new Function<File,Void>(){
    @Override public Void apply(    final File input) throws Exception {
      try {
        processor.process(null,new FileReader(input),new StringWriter());
        Assert.fail("Expected to fail, but didn't");
      }
 catch (      final WroRuntimeException e) {
      }
      return null;
    }
  }
);
}
