@Test public void should_pass_if_actual_contains_given_values_only_more_than_once_according_to_custom_comparison_strategy(){
  actual=arrayOf(6f,-8f,10f,-8f,-8f,-8f);
  arraysWithCustomComparisonStrategy.assertContainsOnly(someInfo(),actual,arrayOf(6f,-8f,10f));
}
