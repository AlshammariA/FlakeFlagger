@Test public void should_pass_if_actual_does_not_contain_given_values_according_to_custom_comparison_strategy(){
  arraysWithCustomComparisonStrategy.assertDoesNotContain(someInfo(),actual,arrayOf(12));
}
