@Test public void shouldBeThreadSafe() throws Exception {
  final RhinoCoffeeScriptProcessor processor=new RhinoCoffeeScriptProcessor();
  final Callable<Void> task=new Callable<Void>(){
    @Override public Void call(){
      try {
        processor.process(new StringReader("square = (x) -> x * x"),new StringWriter());
      }
 catch (      final Exception e) {
        throw new RuntimeException(e);
      }
      return null;
    }
  }
;
  WroTestUtils.runConcurrently(task,30);
}
