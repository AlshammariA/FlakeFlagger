@Test public void shouldBeThreadSafe() throws Exception {
  factory=new JsonModelFactory(){
    @Override protected InputStream getModelResourceAsStream() throws IOException {
      return TestGroovyModelFactory.class.getResourceAsStream("wro.json");
    }
  }
;
  WroTestUtils.init(factory);
  final WroModel expected=factory.create();
  WroTestUtils.runConcurrently(new Callable<Void>(){
    @Override public Void call() throws Exception {
      Assert.assertEquals(expected,factory.create());
      return null;
    }
  }
,10);
}
