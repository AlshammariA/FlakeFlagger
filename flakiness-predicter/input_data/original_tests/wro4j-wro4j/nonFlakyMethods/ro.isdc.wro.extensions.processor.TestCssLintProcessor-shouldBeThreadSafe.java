@Test public void shouldBeThreadSafe() throws Exception {
  final CssLintProcessor lessCss=new CssLintProcessor(){
    @Override protected void onCssLintException(    final CssLintException e,    final Resource resource){
      throw e;
    }
  }
;
  final Callable<Void> task=new Callable<Void>(){
    @Override public Void call(){
      try {
        lessCss.process(new StringReader(createValidCss()),new StringWriter());
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
