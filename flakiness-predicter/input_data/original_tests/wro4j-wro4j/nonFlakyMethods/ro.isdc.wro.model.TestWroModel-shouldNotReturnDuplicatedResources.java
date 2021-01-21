@Test public void shouldNotReturnDuplicatedResources(){
  final WroModel model=new WroModel();
  assertEquals(0,new WroModelInspector(model).getAllUniqueResources().size());
  model.addGroup(new Group("one").addResource(Resource.create("/one.js"))).addGroup(new Group("two").addResource(Resource.create("/one.js")));
  assertEquals(1,new WroModelInspector(model).getAllUniqueResources().size());
}
