@Test public void shouldLoadEmptyModel(){
  final WroModel model=loadModelFromLocation("emptyModel.xml");
  assertEquals(0,model.getGroups().size());
}
