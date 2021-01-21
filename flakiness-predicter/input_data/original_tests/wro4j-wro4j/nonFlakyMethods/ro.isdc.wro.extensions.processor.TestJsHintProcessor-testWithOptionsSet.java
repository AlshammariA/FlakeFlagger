@Test public void testWithOptionsSet() throws Exception {
  final ThreadLocal<Throwable> cause=new ThreadLocal<Throwable>();
  final ResourcePostProcessor processor=new JsHintProcessor(){
    @Override protected void onLinterException(    final LinterException e,    final Resource resource){
      cause.set(e);
    }
  }
.setOptionsAsString("maxerr=1");
  processor.process(new StringReader("alert(;"),new StringWriter());
  Assert.assertNotNull(cause.get());
}
