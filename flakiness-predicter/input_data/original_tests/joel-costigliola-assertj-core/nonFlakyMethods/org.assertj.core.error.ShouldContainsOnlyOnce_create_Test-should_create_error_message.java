@Test public void should_create_error_message(){
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertEquals("[Test] \nExpecting:\n" + " <[\"Yoda\", \"Han\", \"Han\"]>\n" + "to contain only once:\n"+ " <[\"Luke\", \"Yoda\"]>\n"+ "but some elements were not found:\n"+ " <[\"Luke\"]>\n"+ "and others were found more than once:\n"+ " <[\"Han\"]>\n",message);
}
