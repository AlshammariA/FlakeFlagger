@Test public void should_pass_if_actual_contains_only_null_values_according_to_custom_comparison_strategy(){
  actual=array((String)null,(String)null);
  arraysWithCustomComparisonStrategy.assertContainsNull(someInfo(),actual);
}
