@Test public void shouldBeThreadSafe() throws Exception {
  factory=new XmlModelFactory(){
    @Override protected InputStream getModelResourceAsStream(){
      return TestXmlModelFactory.class.getResourceAsStream("testimport/validImports.xml");
    }
  }
;
  WroTestUtils.init(factory);
  final WroModel expected=factory.create();
  WroTestUtils.runConcurrently(new ContextPropagatingCallable<Void>(new Callable<Void>(){
    public Void call() throws Exception {
      assertEquals(expected,factory.create());
      return null;
    }
  }
),10);
}
