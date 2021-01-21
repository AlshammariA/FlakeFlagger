@Test public void should_create_error_message_with_all_fields_differences(){
  factory=shouldBeEqualComparingOnlyGivenFields(new Jedi("Luke","blue"),newArrayList("name","lightSaberColor"),newArrayList((Object)"Luke","blue"),newArrayList((Object)"Yoda","green"),newArrayList("name","lightSaberColor"));
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertThat(message).isEqualTo("[Test] \n" + "Expecting values:\n" + "  <[\"Yoda\", \"green\"]>\n"+ "in fields:\n"+ "  <[\"name\", \"lightSaberColor\"]>\n"+ "but were:\n"+ "  <[\"Luke\", \"blue\"]>\n"+ "in <Luke the Jedi>.\n"+ "Comparison was performed on fields:\n"+ "  <[\"name\", \"lightSaberColor\"]>");
}
