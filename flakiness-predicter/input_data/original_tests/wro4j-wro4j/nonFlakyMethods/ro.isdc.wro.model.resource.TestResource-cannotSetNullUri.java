@Test(expected=NullPointerException.class) public void cannotSetNullUri(){
  final Resource resource=new Resource();
  resource.setUri(null);
}
