@Test public void shouldBeThreadSafe() throws Exception {
  final UglifyJsProcessor processor=new UglifyJsProcessor(){
    @Override protected void onException(    final WroRuntimeException e){
      throw e;
    }
  }
;
  final Callable<Void> task=new Callable<Void>(){
    @Override public Void call(){
      try {
        processor.process(new StringReader("alert(1);"),new StringWriter());
      }
 catch (      final Exception e) {
        throw new RuntimeException(e);
      }
      return null;
    }
  }
;
  WroTestUtils.runConcurrently(task);
}
