@Test public void canBeExecutedMultipleTimes() throws Exception {
  final JsLintProcessor processor=new JsLintProcessor();
  final Callable<Void> task=new Callable<Void>(){
    @Override public Void call(){
      try {
        processor.process(null,new StringReader("var i = 1;"),new StringWriter());
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
