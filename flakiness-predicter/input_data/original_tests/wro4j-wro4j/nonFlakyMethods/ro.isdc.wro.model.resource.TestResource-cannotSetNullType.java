@Test(expected=NullPointerException.class) public void cannotSetNullType(){
  final Resource resource=new Resource();
  resource.setType(null);
}
