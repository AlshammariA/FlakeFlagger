/** 
 * This test was created initially to prove that  {@link JsHintProcessor} is thread-safe, but it doesn't work well whentrying to reuse the scope. TODO: This needs to be investigated.
 */
@Test public void canBeExecutedMultipleTimes() throws Exception {
  final JsHintProcessor processor=new JsHintProcessor();
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
