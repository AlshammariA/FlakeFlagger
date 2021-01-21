@Test public void should_create_error_message_with_custom_comparison_strategy(){
  factory=shouldContain("Yoda","Luke",new ComparatorBasedComparisonStrategy(CaseInsensitiveStringComparator.instance));
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertEquals("[Test] \nExpecting:\n <\"Yoda\">\nto contain:\n <\"Luke\"> when comparing values using 'CaseInsensitiveStringComparator'",message);
}
