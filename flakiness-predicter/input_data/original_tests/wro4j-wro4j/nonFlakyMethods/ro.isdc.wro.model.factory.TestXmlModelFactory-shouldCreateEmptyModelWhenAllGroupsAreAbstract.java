@Test public void shouldCreateEmptyModelWhenAllGroupsAreAbstract(){
  final WroModel model=loadModelFromLocation("shouldCreateEmptyModelWhenAllGroupsAreAbstract.xml");
  assertTrue(model.getGroups().isEmpty());
}
