@Test public void shouldInvokePreProcessorWithResourceNotWantingMinimize() throws Exception {
  victim=new MinimizeAwareProcessorDecorator(mockPreProcessor);
  initVictim();
  final Resource resource=Resource.create("someResource.js");
  resource.setMinimize(false);
  victim.process(resource,mockReader,mockWriter);
  Mockito.verify(mockPreProcessor,Mockito.atLeastOnce()).process(Mockito.any(Resource.class),Mockito.any(Reader.class),Mockito.any(Writer.class));
}
