@Test public void should_pass_if_actual_contains_only_one_comparable_element_according_to_custom_comparison_strategy(){
  actual=array("Obiwan");
  arraysWithCustomComparisonStrategy.assertIsSorted(someInfo(),actual);
}
