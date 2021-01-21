@Test public void shouldInvokeImportAwareProcessor() throws Exception {
  mockPreProcessor=Mockito.spy(new ImportAwareProcessor());
  victim=new ImportAwareProcessorDecorator(mockPreProcessor,ProcessingType.IMPORT_ONLY);
  initVictim();
  victim.process(null,mockReader,mockWriter);
  Mockito.verify(mockPreProcessor,Mockito.atLeastOnce()).process(Mockito.any(Resource.class),Mockito.any(Reader.class),Mockito.any(Writer.class));
}
