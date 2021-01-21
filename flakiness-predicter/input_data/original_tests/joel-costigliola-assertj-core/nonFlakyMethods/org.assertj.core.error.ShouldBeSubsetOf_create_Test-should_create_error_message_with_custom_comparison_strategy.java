@Test public void should_create_error_message_with_custom_comparison_strategy(){
  ErrorMessageFactory factory=shouldBeSubsetOf(newArrayList("Yoda","Luke"),newArrayList("Han","Luke"),newArrayList("Yoda"),new ComparatorBasedComparisonStrategy(CaseInsensitiveStringComparator.instance));
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertThat(message).isEqualTo("[Test] \nExpecting when comparing values using 'CaseInsensitiveStringComparator':\n <[\"Yoda\", \"Luke\"]>\nto be subset of\n <[\"Han\", \"Luke\"]>\nbut found these extra elements:\n <[\"Yoda\"]>");
}
