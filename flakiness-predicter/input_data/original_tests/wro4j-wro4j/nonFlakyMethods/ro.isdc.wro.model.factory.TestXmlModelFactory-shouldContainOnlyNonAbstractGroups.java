@Test public void shouldContainOnlyNonAbstractGroups(){
  final WroModel model=loadModelFromLocation("shouldContainOnlyNonAbstractGroups.xml");
  assertEquals(1,model.getGroups().size());
  final Group group=model.getGroups().iterator().next();
  assertEquals("nonAbstract",group.getName());
  assertEquals(5,group.getResources().size());
}
