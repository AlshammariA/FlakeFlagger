@Test(expected=NullPointerException.class) public void cannotCollectResourcesWithNullType(){
  final Group group=new Group("group");
  group.collectResourcesOfType(null);
}
