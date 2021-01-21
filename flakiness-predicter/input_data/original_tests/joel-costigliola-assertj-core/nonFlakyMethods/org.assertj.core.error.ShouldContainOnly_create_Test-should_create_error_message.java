@Test public void should_create_error_message(){
  ErrorMessageFactory factory=shouldContainOnly(newArrayList("Yoda","Han"),newArrayList("Luke","Yoda"),newLinkedHashSet("Luke"),newLinkedHashSet("Han"));
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertThat(message).isEqualTo("[Test] \n" + "Expecting:\n" + "  <[\"Yoda\", \"Han\"]>\n"+ "to contain only:\n"+ "  <[\"Luke\", \"Yoda\"]>\n"+ "elements not found:\n"+ "  <[\"Luke\"]>\n"+ "and elements not expected:\n"+ "  <[\"Han\"]>\n");
}
