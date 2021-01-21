@Test public void shouldReplaceAResourceWithSameResource(){
  final Group group=new Group("group");
  final Resource resource=Resource.create("/path.js");
  group.addResource(resource);
  final List<Resource> resourceList=new ArrayList<Resource>();
  resourceList.add(resource);
  group.replace(resource,resourceList);
  Assert.assertFalse(group.getResources().isEmpty());
}
