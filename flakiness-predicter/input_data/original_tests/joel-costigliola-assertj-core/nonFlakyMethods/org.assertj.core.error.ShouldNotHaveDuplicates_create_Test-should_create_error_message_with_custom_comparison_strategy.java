@Test public void should_create_error_message_with_custom_comparison_strategy(){
  factory=shouldNotHaveDuplicates(newArrayList("Yoda","Yoda","Luke"),newArrayList("Yoda"),new ComparatorBasedComparisonStrategy(CaseInsensitiveStringComparator.instance));
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertEquals("[Test] \nFound duplicate(s):\n <[\"Yoda\"]>\nin:\n <[\"Yoda\", \"Yoda\", \"Luke\"]>\n" + "when comparing values using 'CaseInsensitiveStringComparator'",message);
}
