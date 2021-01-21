@Test public void should_create_error_message_with_custom_comparison_strategy(){
  ErrorMessageFactory factory=shouldContainOnly(newArrayList("Yoda","Han"),newArrayList("Luke","Yoda"),newLinkedHashSet("Luke"),newLinkedHashSet("Han"),CASE_INSENSITIVE_COMPARISON_STRATEGY);
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertThat(message).isEqualTo("[Test] \n" + "Expecting:\n" + "  <[\"Yoda\", \"Han\"]>\n"+ "to contain only:\n"+ "  <[\"Luke\", \"Yoda\"]>\n"+ "elements not found:\n"+ "  <[\"Luke\"]>\n"+ "and elements not expected:\n"+ "  <[\"Han\"]>\n"+ "when comparing values using 'CaseInsensitiveStringComparator'");
}
