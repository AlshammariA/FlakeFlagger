@Test(expected=NullPointerException.class) public void shouldNotAcceptNullUri(){
  Resource.create(null,null);
}
