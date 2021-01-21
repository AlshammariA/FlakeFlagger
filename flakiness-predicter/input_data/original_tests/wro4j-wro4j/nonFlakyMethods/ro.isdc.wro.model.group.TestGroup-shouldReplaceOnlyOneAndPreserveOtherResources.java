@Test public void shouldReplaceOnlyOneAndPreserveOtherResources(){
  final Group group=new Group("group");
  final Resource resource=Resource.create("/static/*",ResourceType.JS);
  final Resource r0=Resource.create("/asset/1.js",ResourceType.JS);
  group.addResource(r0);
  final Resource r1=Resource.create("/asset/2.js",ResourceType.JS);
  group.addResource(r1);
  group.addResource(resource);
  group.replace(resource,Arrays.asList(Resource.create("/static/one.js",ResourceType.JS),Resource.create("/static/two.js",ResourceType.JS)));
  Assert.assertEquals(4,group.getResources().size());
  Assert.assertEquals(r0,group.getResources().get(0));
  Assert.assertEquals(r1,group.getResources().get(1));
}
