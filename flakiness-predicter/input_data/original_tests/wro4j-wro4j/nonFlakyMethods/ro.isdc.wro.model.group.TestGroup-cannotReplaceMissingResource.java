@Test(expected=IllegalArgumentException.class) public void cannotReplaceMissingResource(){
  final Group group=new Group("group");
  group.replace(Resource.create("/path",ResourceType.JS),Arrays.asList(Resource.create("",ResourceType.JS)));
}
