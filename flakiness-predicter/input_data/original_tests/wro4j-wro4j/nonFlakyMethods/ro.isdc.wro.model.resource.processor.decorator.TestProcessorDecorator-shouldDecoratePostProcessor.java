@Test public void shouldDecoratePostProcessor(){
  final String expected="TestProcessor";
  final ResourcePostProcessor postProcessor=new ResourcePostProcessor(){
    public void process(    final Reader reader,    final Writer writer) throws IOException {
    }
    @Override public String toString(){
      return expected;
    }
  }
;
  final ProcessorDecorator decorator=new ProcessorDecorator(new ProcessorDecorator(new ProcessorDecorator(postProcessor)));
  assertEquals(expected,decorator.toString());
}
