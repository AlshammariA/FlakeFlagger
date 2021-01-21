@Test public void shouldNotInvokeMinimizeAwarePreProcessorWithResourceNotWantingMinimize() throws Exception {
  victim=new MinimizeAwareProcessorDecorator(new MinimizeAwareProcessor());
  initVictim();
  final Resource resource=Resource.create("someResource.js");
  resource.setMinimize(false);
  victim.process(resource,mockReader,mockWriter);
  Mockito.verify(mockPreProcessor,Mockito.never()).process(Mockito.any(Resource.class),Mockito.any(Reader.class),Mockito.any(Writer.class));
}
