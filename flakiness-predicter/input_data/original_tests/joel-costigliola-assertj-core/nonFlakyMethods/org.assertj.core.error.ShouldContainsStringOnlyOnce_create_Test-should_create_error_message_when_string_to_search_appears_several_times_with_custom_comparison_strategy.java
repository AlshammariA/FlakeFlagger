@Test public void should_create_error_message_when_string_to_search_appears_several_times_with_custom_comparison_strategy(){
  ErrorMessageFactory factory=shouldContainOnlyOnce("aaamotIFmoTifaabbbmotifaaa","MOtif",3,new ComparatorBasedComparisonStrategy(CaseInsensitiveStringComparator.instance));
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertEquals("[Test] \nExpecting:\n <\"MOtif\">\nto appear only once in:\n <\"aaamotIFmoTifaabbbmotifaaa\">\nbut it appeared 3 times when comparing values using 'CaseInsensitiveStringComparator'",message);
}
