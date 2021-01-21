@Test public void should_create_error_message_with_custom_comparison_strategy(){
  factory=shouldBeGreaterOrEqual(6,8,new ComparatorBasedComparisonStrategy(new AbsValueComparator<Integer>()));
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertThat(message).isEqualTo("[Test] \n" + "Expecting:\n" + " <6>\n"+ "to be greater than or equal to:\n"+ " <8> when comparing values using 'AbsValueComparator'");
}
