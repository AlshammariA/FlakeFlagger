@Test(expected=IllegalArgumentException.class) public void cannotAcceptObjectWhichIsNotProcessor(){
  victim=new ImportAwareProcessorDecorator(new Object(),ProcessingType.ALL);
}
