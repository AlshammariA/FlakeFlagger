@Test public void shouldBeThreadSafe() throws Exception {
  final SassCssProcessor processor=new SassCssProcessor(){
    @Override protected void onException(    final WroRuntimeException e){
      throw e;
    }
  }
;
  final Callable<Void> task=new Callable<Void>(){
    public Void call(){
      try {
        processor.process(new StringReader("#id {.class {color: red;}}"),new StringWriter());
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
