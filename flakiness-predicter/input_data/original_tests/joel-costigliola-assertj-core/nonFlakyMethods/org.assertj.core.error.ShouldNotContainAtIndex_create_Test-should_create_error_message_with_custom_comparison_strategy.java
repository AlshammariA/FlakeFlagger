@Test public void should_create_error_message_with_custom_comparison_strategy(){
  factory=shouldNotContainAtIndex(newArrayList("Yoda","Luke"),"Luke",atIndex(1),new ComparatorBasedComparisonStrategy(CaseInsensitiveStringComparator.instance));
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertEquals("[Test] \nExpecting:\n <[\"Yoda\", \"Luke\"]>\nnot to contain:\n <\"Luke\">\n" + "at index <1>\n" + "when comparing values using 'CaseInsensitiveStringComparator'",message);
}
