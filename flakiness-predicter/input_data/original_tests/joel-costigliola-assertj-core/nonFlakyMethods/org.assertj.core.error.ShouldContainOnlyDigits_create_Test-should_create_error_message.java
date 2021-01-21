@Test public void should_create_error_message(){
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertThat(message).isEqualTo("[Test] \n" + "Expecting:\n" + "  <\"10$\">\n"+ "to contain only digits\n"+ "but found non-digit character <'$'> at index <2>");
}
