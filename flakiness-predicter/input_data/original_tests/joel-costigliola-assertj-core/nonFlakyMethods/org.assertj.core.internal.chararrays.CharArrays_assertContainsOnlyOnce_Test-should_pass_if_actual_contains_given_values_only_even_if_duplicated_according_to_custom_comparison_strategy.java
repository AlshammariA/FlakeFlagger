@Test public void should_pass_if_actual_contains_given_values_only_even_if_duplicated_according_to_custom_comparison_strategy(){
  arraysWithCustomComparisonStrategy.assertContainsOnlyOnce(someInfo(),actual,arrayOf('a','b','c','A','b','C'));
}
