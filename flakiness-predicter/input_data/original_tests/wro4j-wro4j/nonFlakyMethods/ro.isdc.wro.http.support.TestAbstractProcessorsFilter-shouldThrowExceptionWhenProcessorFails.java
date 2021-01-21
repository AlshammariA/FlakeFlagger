@Test(expected=WroRuntimeException.class) public void shouldThrowExceptionWhenProcessorFails() throws Exception {
  final List<ResourcePreProcessor> processors=new ArrayList<ResourcePreProcessor>();
  processors.add(new ResourcePreProcessor(){
    public void process(    final Resource resource,    final Reader reader,    final Writer writer) throws IOException {
      throw new WroRuntimeException("processor fails");
    }
  }
);
  doFilterWithProcessors(processors);
}
