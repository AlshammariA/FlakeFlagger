@Test public void should_pass_if_actual_and_sequence_are_equal_according_to_custom_comparison_strategy(){
  arraysWithCustomComparisonStrategy.assertStartsWith(someInfo(),actual,arrayOf(6d,-8d,10d,12d));
}
