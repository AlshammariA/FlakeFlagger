@Test public void shouldComputeEligibilityForProcessorWithNoTypeAndNotMinimizeAware(){
  final ResourcePreProcessor noOpProcessor=new ResourcePreProcessor(){
    public void process(    final Resource resource,    final Reader reader,    final Writer writer) throws IOException {
    }
  }
;
  assertTrue(new ProcessorDecorator(noOpProcessor).isEligible(true,ResourceType.CSS));
  assertTrue(new ProcessorDecorator(noOpProcessor).isEligible(false,ResourceType.CSS));
  assertTrue(new ProcessorDecorator(noOpProcessor).isEligible(true,ResourceType.JS));
  assertTrue(new ProcessorDecorator(noOpProcessor).isEligible(false,ResourceType.JS));
}
