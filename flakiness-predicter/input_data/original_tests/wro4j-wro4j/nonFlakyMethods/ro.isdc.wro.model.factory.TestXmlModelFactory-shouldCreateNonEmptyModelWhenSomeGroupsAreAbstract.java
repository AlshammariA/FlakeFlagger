@Test public void shouldCreateNonEmptyModelWhenSomeGroupsAreAbstract(){
  final WroModel model=loadModelFromLocation("shouldCreateNonEmptyModelWhenSomeGroupsAreAbstract.xml");
  assertEquals(2,model.getGroups().size());
}
