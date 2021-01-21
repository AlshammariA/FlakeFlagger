@Test public void should_create_error_message_with_hexadecimal_representation(){
  String message=factory.create(new TextDescription("Test"),new HexadecimalRepresentation());
  assertThat(message).isEqualTo("[Test] \nExpected size:<2> but was:<4> in:\n<['0x0061', '0x0062']>");
}
