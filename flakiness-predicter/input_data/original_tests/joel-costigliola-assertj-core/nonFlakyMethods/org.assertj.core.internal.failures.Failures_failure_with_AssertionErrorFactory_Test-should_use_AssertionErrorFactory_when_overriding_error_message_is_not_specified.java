@Test public void should_use_AssertionErrorFactory_when_overriding_error_message_is_not_specified(){
  MyOwnAssertionError expectedError=new MyOwnAssertionError("[description] my message");
  Description description=new TestDescription("description");
  info.description(description);
  when(errorFactory.newAssertionError(description,info.representation())).thenReturn(expectedError);
  AssertionError failure=failures.failure(info,errorFactory);
  assertSame(expectedError,failure);
}
