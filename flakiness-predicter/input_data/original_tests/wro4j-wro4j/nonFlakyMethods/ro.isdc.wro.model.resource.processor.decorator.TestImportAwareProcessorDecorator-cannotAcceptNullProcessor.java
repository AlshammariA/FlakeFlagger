@Test(expected=NullPointerException.class) public void cannotAcceptNullProcessor(){
  victim=new ImportAwareProcessorDecorator(null,ProcessingType.ALL);
}
