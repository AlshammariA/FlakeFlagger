@SuppressWarnings("unchecked") @Test public void testReplaceWithEmptyCollection(){
  final Group group=new Group("group");
  final Resource resource=Resource.create("/path",ResourceType.JS);
  group.addResource(resource);
  group.replace(resource,Collections.EMPTY_LIST);
  Assert.assertTrue(group.getResources().isEmpty());
}
