@Test public void decoratedModelshouldBeThreadSafe() throws Exception {
  final List<Transformer<WroModel>> modelTransformers=new ArrayList<Transformer<WroModel>>();
  modelTransformers.add(new WildcardExpanderModelTransformer());
  victim=DefaultWroModelFactoryDecorator.decorate(new XmlModelFactory(){
    @Override protected InputStream getModelResourceAsStream() throws IOException {
      return TestXmlModelFactory.class.getResourceAsStream("wroWithWildcardResources.xml");
    }
  }
,modelTransformers);
  WroTestUtils.init(victim);
  final WroModel expectedModel=victim.create();
  WroTestUtils.runConcurrently(new ContextPropagatingCallable<Void>(new Callable<Void>(){
    public Void call() throws Exception {
      Assert.assertEquals(expectedModel,victim.create());
      return null;
    }
  }
));
}
