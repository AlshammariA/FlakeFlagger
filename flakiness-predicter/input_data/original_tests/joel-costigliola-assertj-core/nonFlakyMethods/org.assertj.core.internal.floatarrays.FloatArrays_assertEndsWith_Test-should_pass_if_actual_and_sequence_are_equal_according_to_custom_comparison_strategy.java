@Test public void should_pass_if_actual_and_sequence_are_equal_according_to_custom_comparison_strategy(){
  arraysWithCustomComparisonStrategy.assertEndsWith(someInfo(),actual,arrayOf(6f,-8f,10f,12f));
}
