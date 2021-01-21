@Test(expected=WroRuntimeException.class) public void shouldThrowRuntimeExceptionWhenProcessingFails() throws Exception {
  Mockito.doThrow(new IOException("BOOM")).when(mockProcessor).process(Mockito.any(Resource.class),Mockito.any(Reader.class),Mockito.any(Writer.class));
  victim.process(mockResource,new StringReader(""),new StringWriter());
}
