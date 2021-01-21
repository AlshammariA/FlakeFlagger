@Test public void shouldBeThreadSafe() throws Exception {
  final Callable<Void> task=new Callable<Void>(){
    public Void call(){
      try {
        processor.process(new StringReader("h3#heading {  font-size: modular-scale(14px, 1, 1.618); }"),new StringWriter());
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
