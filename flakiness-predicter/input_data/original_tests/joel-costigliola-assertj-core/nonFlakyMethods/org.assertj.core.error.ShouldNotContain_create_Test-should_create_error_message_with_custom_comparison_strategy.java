@Test public void should_create_error_message_with_custom_comparison_strategy(){
  ErrorMessageFactory factory=shouldNotContain(newArrayList("Yoda"),newArrayList("Luke","Yoda"),newLinkedHashSet("Yoda"),new ComparatorBasedComparisonStrategy(CaseInsensitiveStringComparator.instance));
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertThat(message).isEqualTo("[Test] \n" + "Expecting\n" + " <[\"Yoda\"]>\n"+ "not to contain\n"+ " <[\"Luke\", \"Yoda\"]>\n"+ "but found\n <[\"Yoda\"]>\n"+ "when comparing values using 'CaseInsensitiveStringComparator'");
}
