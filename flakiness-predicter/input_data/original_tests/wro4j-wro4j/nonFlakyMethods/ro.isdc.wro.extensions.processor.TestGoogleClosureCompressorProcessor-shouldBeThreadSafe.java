@Test public void shouldBeThreadSafe() throws Exception {
  WroTestUtils.runConcurrently(new Callable<Void>(){
    @Override public Void call() throws Exception {
      victim.process(null,new StringReader("alert(1);"),new StringWriter());
      return null;
    }
  }
);
}
