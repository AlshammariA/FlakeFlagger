@Test public void testResoruceOfTypeFound(){
  final Group group=new Group("group");
  final List<Resource> resources=new ArrayList<Resource>();
  resources.add(Resource.create("/some.css",ResourceType.CSS));
  group.setResources(resources);
  Assert.assertEquals(true,group.hasResourcesOfType(ResourceType.CSS));
  Assert.assertEquals(false,group.hasResourcesOfType(ResourceType.JS));
}
