@Test public void shouldNotChangeTheModelWhenNoTransformersProvided(){
  factory=new ModelTransformerFactory(mockFactory);
  Assert.assertEquals(new WroModel().getGroups(),factory.create().getGroups());
}
