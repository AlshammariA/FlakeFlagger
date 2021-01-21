@Test public void should_create_error_message_with_custom_comparison_strategy(){
  factory=shouldBeIn("Yoda",array("Luke","Leia"),new ComparatorBasedComparisonStrategy(CaseInsensitiveStringComparator.instance));
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertEquals("[Test] \nExpecting:\n <\"Yoda\">\nto be in:\n <[\"Luke\", \"Leia\"]>\nwhen comparing values using 'CaseInsensitiveStringComparator'",message);
}
