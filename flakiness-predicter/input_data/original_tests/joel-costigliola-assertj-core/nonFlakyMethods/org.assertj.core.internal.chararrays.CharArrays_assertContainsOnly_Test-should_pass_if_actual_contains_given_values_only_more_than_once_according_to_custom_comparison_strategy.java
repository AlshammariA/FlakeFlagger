@Test public void should_pass_if_actual_contains_given_values_only_more_than_once_according_to_custom_comparison_strategy(){
  actual=arrayOf('A','b','c','c','c');
  arraysWithCustomComparisonStrategy.assertContainsOnly(someInfo(),actual,arrayOf('A','b','c'));
}
