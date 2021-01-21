@Test public void shouldBeThreadSafe() throws Exception {
  final Callable<Void> task=new Callable<Void>(){
    @Override public Void call(){
      try {
        processor.process(new StringReader("$side: top;$radius: 10px;.rounded-#{$side} {border-#{$side}-radius: $radius;}"),new StringWriter());
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
