@Test public void should_pass_if_actual_contains_null_more_than_once_according_to_custom_comparison_strategy(){
  actual=array("Luke",null,null);
  arraysWithCustomComparisonStrategy.assertContainsNull(someInfo(),actual);
}
