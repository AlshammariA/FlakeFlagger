@Test public void should_pass_if_actual_contains_sequence_according_to_custom_comparison_strategy(){
  arraysWithCustomComparisonStrategy.assertContainsSequence(someInfo(),actual,arrayOf(6d,-8d));
}
