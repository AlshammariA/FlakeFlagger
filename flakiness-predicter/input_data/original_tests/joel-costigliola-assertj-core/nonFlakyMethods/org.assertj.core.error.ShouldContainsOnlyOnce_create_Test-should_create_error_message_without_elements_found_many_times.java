@Test public void should_create_error_message_without_elements_found_many_times(){
  factory=shouldContainsOnlyOnce(newArrayList("Yoda","Han"),newArrayList("Luke"),newLinkedHashSet("Luke"),newLinkedHashSet());
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertEquals("[Test] \nExpecting:\n" + " <[\"Yoda\", \"Han\"]>\n" + "to contain only once:\n"+ " <[\"Luke\"]>\n"+ "but some elements were not found:\n"+ " <[\"Luke\"]>\n",message);
}
