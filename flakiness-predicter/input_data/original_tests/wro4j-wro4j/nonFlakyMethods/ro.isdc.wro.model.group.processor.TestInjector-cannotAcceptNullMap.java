@Test(expected=NullPointerException.class) public void cannotAcceptNullMap(){
  victim=new Injector(null);
}
