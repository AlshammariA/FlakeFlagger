@Test public void should_pass_if_actual_ends_with_sequence_according_to_custom_comparison_strategy(){
  arraysWithCustomComparisonStrategy.assertEndsWith(someInfo(),actual,arrayOf(-8f,10f,12f));
}
