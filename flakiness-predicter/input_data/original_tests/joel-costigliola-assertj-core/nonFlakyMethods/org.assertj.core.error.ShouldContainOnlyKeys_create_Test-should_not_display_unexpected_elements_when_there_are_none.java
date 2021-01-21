@Test public void should_not_display_unexpected_elements_when_there_are_none(){
  ErrorMessageFactory factory=shouldContainOnlyKeys(mapOf(entry("color","green")),newArrayList("jedi","color"),newLinkedHashSet("jedi"),Collections.emptySet());
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertThat(message).isEqualTo("[Test] \n" + "Expecting:\n" + "  <{\"color\"=\"green\"}>\n"+ "to contain only following keys:\n"+ "  <[\"jedi\", \"color\"]>\n"+ "but could not find the following keys:\n"+ "  <[\"jedi\"]>\n");
}
