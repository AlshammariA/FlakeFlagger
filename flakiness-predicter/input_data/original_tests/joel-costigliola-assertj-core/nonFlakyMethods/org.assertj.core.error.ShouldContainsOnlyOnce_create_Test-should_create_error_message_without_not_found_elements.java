@Test public void should_create_error_message_without_not_found_elements(){
  factory=shouldContainsOnlyOnce(newArrayList("Yoda","Han","Han"),newArrayList("Yoda"),newLinkedHashSet(),newLinkedHashSet("Han"));
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertEquals("[Test] \nExpecting:\n" + " <[\"Yoda\", \"Han\", \"Han\"]>\n" + "to contain only once:\n"+ " <[\"Yoda\"]>\n"+ "but some elements were found more than once:\n"+ " <[\"Han\"]>\n",message);
}
