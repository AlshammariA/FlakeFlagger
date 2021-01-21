@Test public void should_create_error_message_for_empty_string(){
  factory=shouldContainOnlyDigits("");
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertThat(message).isEqualTo("[Test] \n" + "Expecting:\n" + "  <\"\">\n"+ "to contain only digits\n"+ "but could not found any digits at all");
}
