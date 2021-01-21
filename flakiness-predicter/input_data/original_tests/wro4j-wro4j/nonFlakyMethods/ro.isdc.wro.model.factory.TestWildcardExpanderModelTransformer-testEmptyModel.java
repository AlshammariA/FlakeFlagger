@Test public void testEmptyModel(){
  final WroModel model=new WroModel();
  Mockito.when(decoratedFactory.create()).thenReturn(model);
  final WroModel changedModel=transformer.transform(model);
  Assert.assertEquals(model.getGroups().size(),changedModel.getGroups().size());
}
