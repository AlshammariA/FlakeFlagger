@Test public void should_create_error_message_with_custom_comparison_strategy(){
  factory=shouldBeLess(8,6,new ComparatorBasedComparisonStrategy(new AbsValueComparator<Integer>()));
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertThat(message).isEqualTo("[Test] \n" + "Expecting:\n" + " <8>\n"+ "to be less than:\n"+ " <6> when comparing values using 'AbsValueComparator'");
}
