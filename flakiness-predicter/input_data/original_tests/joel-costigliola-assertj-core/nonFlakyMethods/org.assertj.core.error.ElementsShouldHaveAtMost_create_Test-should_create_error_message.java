@Test public void should_create_error_message(){
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertEquals("[Test] \nExpecting elements:\n<[\"Yoda\", \"Luke\", \"Obiwan\"]>\n to have at most 2 times <Jedi power>",message);
}
