@Test public void should_create_error_message_with_custom_comparison_strategy(){
  factory=shouldNotBeIn("Luke",array("Luke","Leia"),new ComparatorBasedComparisonStrategy(CaseInsensitiveStringComparator.instance));
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertThat(message).isEqualTo("[Test] \n" + "Expecting:\n" + " <\"Luke\">\n"+ "not to be in:\n"+ " <[\"Luke\", \"Leia\"]>\n"+ "when comparing values using 'CaseInsensitiveStringComparator'");
}
