@Test public void should_not_display_unexpected_elements_when_there_are_none(){
  ErrorMessageFactory factory=shouldContainOnly(newArrayList("Yoda"),newArrayList("Luke","Yoda"),newLinkedHashSet("Luke"),Collections.emptySet());
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertThat(message).isEqualTo("[Test] \n" + "Expecting:\n" + "  <[\"Yoda\"]>\n"+ "to contain only:\n"+ "  <[\"Luke\", \"Yoda\"]>\n"+ "but could not find the following elements:\n"+ "  <[\"Luke\"]>\n");
}
