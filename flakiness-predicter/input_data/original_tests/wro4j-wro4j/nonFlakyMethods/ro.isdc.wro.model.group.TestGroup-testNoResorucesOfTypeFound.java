@Test public void testNoResorucesOfTypeFound(){
  final Group group=new Group("group");
  Assert.assertEquals(false,group.hasResourcesOfType(ResourceType.CSS));
  Assert.assertEquals(false,group.hasResourcesOfType(ResourceType.JS));
}
