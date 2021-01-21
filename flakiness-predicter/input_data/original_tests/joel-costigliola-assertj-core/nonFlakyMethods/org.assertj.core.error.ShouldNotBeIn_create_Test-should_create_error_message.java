@Test public void should_create_error_message(){
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertThat(message).isEqualTo("[Test] \n" + "Expecting:\n" + " <\"Luke\">\n"+ "not to be in:\n"+ " <[\"Luke\", \"Leia\"]>\n");
}
