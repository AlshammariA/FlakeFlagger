/** 
 * Test that by default, failing to process a js with coffeeScript, will leave the result unchanged.
 */
@Test public void testExceptions() throws IOException {
  final URL url=getClass().getResource("coffeeScript/exceptions");
  final AtomicInteger counter=new AtomicInteger();
  processor=new ExceptionHandlingProcessorDecorator(new RhinoCoffeeScriptProcessor(){
    @Override protected void onException(    final Exception e){
      counter.incrementAndGet();
      super.onException(e);
    }
  }
){
    @Override protected boolean isIgnoreFailingProcessor(){
      return true;
    }
  }
;
  final File testFolder=new File(url.getFile(),"test");
  final File expectedFolder=new File(url.getFile(),"expected");
  WroTestUtils.compareFromDifferentFoldersByExtension(testFolder,expectedFolder,"js",processor);
  Assert.assertEquals(2,counter.get());
}
