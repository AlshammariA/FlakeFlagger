@Test public void should_create_error_message_when_string_to_search_does_not_appear_with_custom_comparison_strategy(){
  ErrorMessageFactory factory=shouldContainOnlyOnce("aaamoDifmoifaabbbmotfaaa","MOtif",0,new ComparatorBasedComparisonStrategy(CaseInsensitiveStringComparator.instance));
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertEquals("[Test] \nExpecting:\n <\"MOtif\">\nto appear only once in:\n <\"aaamoDifmoifaabbbmotfaaa\">\nbut it did not appear when comparing values using 'CaseInsensitiveStringComparator'",message);
}
