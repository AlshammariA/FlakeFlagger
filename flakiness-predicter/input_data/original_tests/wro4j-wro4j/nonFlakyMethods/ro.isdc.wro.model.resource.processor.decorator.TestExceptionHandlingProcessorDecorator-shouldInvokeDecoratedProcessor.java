@Test public void shouldInvokeDecoratedProcessor() throws Exception {
  mockProcessor=Mockito.spy(new JSMinProcessor());
  victim=new ExceptionHandlingProcessorDecorator(mockProcessor);
  WroTestUtils.createInjector().inject(victim);
  final String resourceContent="alert(  1  );";
  final StringWriter writer=new StringWriter();
  final Reader reader=new StringReader(resourceContent);
  victim.process(mockResource,reader,writer);
  Mockito.verify(mockProcessor).process(Mockito.any(Resource.class),Mockito.any(Reader.class),Mockito.any(Writer.class));
  Assert.assertEquals("\nalert(1);",writer.toString());
}
