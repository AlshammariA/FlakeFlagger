@Test(expected=NullPointerException.class) public void cannotProcessNullLazyProcessor() throws Exception {
  victim=new LazyProcessorDecorator(new LazyInitializer<ResourcePreProcessor>(){
    @Override protected ResourcePreProcessor initialize(){
      return null;
    }
  }
);
  WroTestUtils.createInjector().inject(victim);
  victim.process(null,mockReader,mockWriter);
}
