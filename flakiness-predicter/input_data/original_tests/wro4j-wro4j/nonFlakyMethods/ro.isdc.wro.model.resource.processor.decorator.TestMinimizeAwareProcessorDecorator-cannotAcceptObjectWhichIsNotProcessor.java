@Test(expected=IllegalArgumentException.class) public void cannotAcceptObjectWhichIsNotProcessor(){
  victim=new MinimizeAwareProcessorDecorator(new Object(),true);
}
