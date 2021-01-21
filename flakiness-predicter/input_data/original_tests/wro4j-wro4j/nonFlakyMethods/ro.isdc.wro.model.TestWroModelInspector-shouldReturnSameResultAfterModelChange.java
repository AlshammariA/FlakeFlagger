/** 
 * Proves that inspector works only with model snapshot and does not reflect model changes performed after inspector is constructed.
 */
@Test public void shouldReturnSameResultAfterModelChange(){
  final WroModel model=new WroModel();
  victim=new WroModelInspector(model);
  assertEquals(0,victim.getAllUniqueResources().size());
  model.addGroup(new Group("one").addResource(Resource.create("/one.js"))).addGroup(new Group("two").addResource(Resource.create("/one.js")));
  assertEquals(0,victim.getAllUniqueResources().size());
  assertEquals(1,new WroModelInspector(model).getAllUniqueResources().size());
  assertEquals(2,new WroModelInspector(model).getAllResources().size());
}
