@Test public void shouldCollectCorrectNumberOfResourcesByType(){
  final Group group=new Group("group");
  group.addResource(Resource.create("1.js"));
  group.addResource(Resource.create("2.js"));
  group.addResource(Resource.create("3.js"));
  group.addResource(Resource.create("4.js"));
  group.addResource(Resource.create("5.js"));
  group.addResource(Resource.create("6.js"));
  group.addResource(Resource.create("1.css"));
  Assert.assertEquals(6,group.collectResourcesOfType(ResourceType.JS).getResources().size());
  Assert.assertEquals(1,group.collectResourcesOfType(ResourceType.CSS).getResources().size());
}
