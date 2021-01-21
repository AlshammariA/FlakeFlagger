@Test public void should_create_error_message(){
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertEquals("[Test] \nExpecting elements:\n<[\"Yoda\"]>\n of \n<[\"Darth Vader\", \"Leia\", \"Yoda\"]>\n not to be <not a Jedi>",message);
}
