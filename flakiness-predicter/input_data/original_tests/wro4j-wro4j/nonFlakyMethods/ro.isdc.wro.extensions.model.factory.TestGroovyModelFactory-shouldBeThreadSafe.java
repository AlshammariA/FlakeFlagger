@Test public void shouldBeThreadSafe() throws Exception {
  factory=new GroovyModelFactory(){
    @Override protected InputStream getModelResourceAsStream() throws IOException {
      return TestGroovyModelFactory.class.getResourceAsStream("wro.groovy");
    }
  }
;
  WroTestUtils.init(factory);
  final WroModel expectedModel=factory.create();
  WroTestUtils.runConcurrently(new Callable<Void>(){
    @Override public Void call() throws Exception {
      Assert.assertEquals(expectedModel,factory.create());
      return null;
    }
  }
);
}
