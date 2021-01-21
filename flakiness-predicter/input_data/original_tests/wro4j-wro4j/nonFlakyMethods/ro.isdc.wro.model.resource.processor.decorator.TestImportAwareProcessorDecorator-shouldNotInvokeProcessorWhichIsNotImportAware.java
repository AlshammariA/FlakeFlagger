@Test public void shouldNotInvokeProcessorWhichIsNotImportAware() throws Exception {
  victim=new ImportAwareProcessorDecorator(mockPreProcessor,ProcessingType.IMPORT_ONLY);
  initVictim();
  victim.process(mockReader,mockWriter);
  Mockito.verify(mockPreProcessor,Mockito.never()).process(Mockito.any(Resource.class),Mockito.any(Reader.class),Mockito.any(Writer.class));
}
