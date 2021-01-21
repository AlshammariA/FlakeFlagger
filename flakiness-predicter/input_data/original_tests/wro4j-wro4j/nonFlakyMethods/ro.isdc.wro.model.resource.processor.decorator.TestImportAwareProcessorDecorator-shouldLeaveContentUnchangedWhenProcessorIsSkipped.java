@Test public void shouldLeaveContentUnchangedWhenProcessorIsSkipped() throws Exception {
  victim=new ImportAwareProcessorDecorator(mockPreProcessor,ProcessingType.IMPORT_ONLY);
  initVictim();
  final String resourceContent="var i      =     1;";
  final StringWriter writer=new StringWriter();
  victim.process(new StringReader(resourceContent),writer);
  Mockito.verify(mockPostProcessor,Mockito.never()).process(Mockito.any(Reader.class),Mockito.any(Writer.class));
  Assert.assertEquals(resourceContent,writer.toString());
}
