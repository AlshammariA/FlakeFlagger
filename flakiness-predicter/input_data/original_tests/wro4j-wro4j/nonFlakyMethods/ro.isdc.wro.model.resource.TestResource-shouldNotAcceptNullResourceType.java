@Test(expected=NullPointerException.class) public void shouldNotAcceptNullResourceType(){
  Resource.create("resource.js",null);
}
