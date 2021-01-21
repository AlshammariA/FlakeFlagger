@Test public void shouldInvokePreProcessorWhenImportIsSupported() throws Exception {
  final ResourcePreProcessor processor=Mockito.spy(new ImportAwareProcessor());
  victim=new ImportAwareProcessorDecorator(processor,ProcessingType.IMPORT_ONLY);
  initVictim();
  victim.process(mockReader,mockWriter);
  Mockito.verify(processor,Mockito.atLeastOnce()).process(Mockito.any(Resource.class),Mockito.any(Reader.class),Mockito.any(Writer.class));
}
