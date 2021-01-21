@Test public void shouldNotInvokePostProcessorWhichIsNotImportAware() throws Exception {
  victim=new ImportAwareProcessorDecorator(mockPostProcessor,ProcessingType.IMPORT_ONLY);
  initVictim();
  victim.process(mockReader,mockWriter);
  Mockito.verify(mockPostProcessor,Mockito.never()).process(Mockito.any(Reader.class),Mockito.any(Writer.class));
}
