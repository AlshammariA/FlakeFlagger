@Test(expected=NullPointerException.class) public void cannotAcceptNullProcessor(){
  victim=new MinimizeAwareProcessorDecorator(null,true);
}
