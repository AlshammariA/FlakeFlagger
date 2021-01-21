@Test public void decoratedModelShouldBeThreadSafe() throws Exception {
  final List<Transformer<WroModel>> modelTransformers=new ArrayList<Transformer<WroModel>>();
  modelTransformers.add(new WildcardExpanderModelTransformer());
  factory=DefaultWroModelFactoryDecorator.decorate(new GroovyModelFactory(){
    @Override protected InputStream getModelResourceAsStream() throws IOException {
      return TestGroovyModelFactory.class.getResourceAsStream("wro.groovy");
    }
  }
,modelTransformers);
  WroTestUtils.init(factory);
  final WroModel expectedModel=factory.create();
  WroTestUtils.runConcurrently(new ContextPropagatingCallable<Void>(new Callable<Void>(){
    @Override public Void call() throws Exception {
      Assert.assertEquals(expectedModel,factory.create());
      return null;
    }
  }
));
}
