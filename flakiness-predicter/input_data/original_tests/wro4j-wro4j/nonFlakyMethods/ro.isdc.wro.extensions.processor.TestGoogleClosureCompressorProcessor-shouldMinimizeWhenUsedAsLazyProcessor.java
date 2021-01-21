@Test public void shouldMinimizeWhenUsedAsLazyProcessor() throws Exception {
  final ResourcePreProcessor victim=new LazyProcessorDecorator(new LazyInitializer<ResourcePreProcessor>(){
    @Override protected ResourcePreProcessor initialize(){
      return new GoogleClosureCompressorProcessor();
    }
  }
);
  WroTestUtils.createInjector().inject(victim);
  final StringWriter sw=new StringWriter();
  victim.process(null,new StringReader("alert(1);"),sw);
  assertEquals("alert(1);",sw.toString());
}
