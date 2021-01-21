@Test public void shouldNotMinimizeDecoratedResourcesWithMinimizationDisabled() throws Exception {
  final List<Resource> resources=new ArrayList<Resource>();
  final Resource resource=Resource.create("classpath:1.js");
  resource.setMinimize(false);
  resources.add(resource);
  final ResourcePreProcessor preProcessor=CopyrightKeeperProcessorDecorator.decorate(new JSMinProcessor(){
    @Override public void process(    final Resource resource,    final Reader reader,    final Writer writer) throws IOException {
      Assert.fail("Should not minimize");
    }
  }
);
  initExecutor(preProcessor);
  victim.processAndMerge(resources,true);
}
