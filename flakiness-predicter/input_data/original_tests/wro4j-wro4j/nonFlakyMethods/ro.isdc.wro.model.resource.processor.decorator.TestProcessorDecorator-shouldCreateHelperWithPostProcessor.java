@Test public void shouldCreateHelperWithPostProcessor(){
  new ProcessorDecorator(new ResourcePostProcessor(){
    public void process(    final Reader reader,    final Writer writer) throws IOException {
    }
  }
);
}
