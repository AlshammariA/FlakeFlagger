@Test(expected=NullPointerException.class) public void cannotPassNullResourceType(){
  final Group group=new Group("group");
  group.hasResourcesOfType(null);
}
