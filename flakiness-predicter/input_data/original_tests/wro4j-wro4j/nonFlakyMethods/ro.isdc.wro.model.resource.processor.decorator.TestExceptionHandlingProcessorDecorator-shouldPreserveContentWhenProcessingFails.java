@Test public void shouldPreserveContentWhenProcessingFails() throws Exception {
  Context.get().getConfig().setIgnoreFailingProcessor(true);
  Mockito.doThrow(new IOException("BOOM")).when(mockProcessor).process(Mockito.any(Resource.class),Mockito.any(Reader.class),Mockito.any(Writer.class));
  final String resourceContent="alert(1);";
  final StringWriter writer=new StringWriter();
  final Reader reader=new StringReader(resourceContent);
  victim.process(mockResource,reader,writer);
  Mockito.verify(mockProcessor).process(Mockito.any(Resource.class),Mockito.any(Reader.class),Mockito.any(Writer.class));
  Assert.assertEquals(resourceContent,writer.toString());
}
