@Test public void shouldChangeTheModelWhenTransformersProvided(){
  final Transformer<WroModel> transformer=new Transformer<WroModel>(){
    public WroModel transform(    final WroModel input){
      return null;
    }
  }
;
  factory=new ModelTransformerFactory(mockFactory).setTransformers(Arrays.asList(transformer,transformer));
  WroTestUtils.createInjector().inject(factory);
  Assert.assertNull(factory.create());
}
