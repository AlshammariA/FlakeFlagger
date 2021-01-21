@Test public void testReplaceWithFewResources(){
  final Group group=new Group("group");
  final Resource resource=Resource.create("/static/*",ResourceType.JS);
  resource.setMinimize(false);
  group.addResource(resource);
  group.replace(resource,Arrays.asList(Resource.create("/static/one.js",ResourceType.JS),Resource.create("/static/two.js",ResourceType.JS)));
  Assert.assertEquals(2,group.getResources().size());
  Assert.assertEquals(resource.isMinimize(),group.getResources().get(0).isMinimize());
}
