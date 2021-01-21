@Test public void shouldCreateHelperWithPreProcessor(){
  new ProcessorDecorator(new ResourcePreProcessor(){
    public void process(    final Resource resource,    final Reader reader,    final Writer writer) throws IOException {
    }
  }
);
}
