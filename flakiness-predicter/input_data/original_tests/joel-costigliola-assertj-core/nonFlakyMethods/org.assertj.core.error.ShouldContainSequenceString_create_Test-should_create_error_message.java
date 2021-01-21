@Test public void should_create_error_message(){
  String[] sequenceValues={"{","author","title","}"};
  String actual="{ 'title':'A Game of Thrones', 'author':'George Martin'}";
  factory=shouldContainSequence(actual,sequenceValues,1);
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertEquals("[Test] \nExpecting:\n <\"" + actual + "\">\n"+ "to contain the following CharSequences in this order:\n"+ " <[\"{\", \"author\", \"title\", \"}\"]>\n"+ "but <\"title\"> was found before <\"author\">\n",message);
}
