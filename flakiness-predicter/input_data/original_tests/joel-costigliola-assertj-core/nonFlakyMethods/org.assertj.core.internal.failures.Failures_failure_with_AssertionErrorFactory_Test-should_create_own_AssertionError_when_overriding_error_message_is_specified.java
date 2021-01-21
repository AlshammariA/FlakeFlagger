@Test public void should_create_own_AssertionError_when_overriding_error_message_is_specified(){
  info.overridingErrorMessage("my message");
  AssertionError failure=failures.failure(info,errorFactory);
  assertEquals("my message",failure.getMessage());
}
