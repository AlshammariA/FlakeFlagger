@Test public void should_pass_with_error_message_overridden(){
  assertions.overridingErrorMessage("new error message").isEqualTo(6L);
}
