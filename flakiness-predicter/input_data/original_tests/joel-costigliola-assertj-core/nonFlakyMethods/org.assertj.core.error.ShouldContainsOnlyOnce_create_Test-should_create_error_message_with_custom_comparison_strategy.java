@Test public void should_create_error_message_with_custom_comparison_strategy(){
  ErrorMessageFactory factory=shouldContainsOnlyOnce(newArrayList("Yoda","Han"),newArrayList("Luke","Yoda"),newLinkedHashSet("Luke"),newLinkedHashSet("Han"),new ComparatorBasedComparisonStrategy(CaseInsensitiveStringComparator.instance));
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertEquals("[Test] \n" + "Expecting:\n" + " <[\"Yoda\", \"Han\"]>\n"+ "to contain only once:\n"+ " <[\"Luke\", \"Yoda\"]>\n"+ "but some elements were not found:\n"+ " <[\"Luke\"]>\n"+ "and others were found more than once:\n"+ " <[\"Han\"]>\n"+ "when comparing values using 'CaseInsensitiveStringComparator'",message);
}
