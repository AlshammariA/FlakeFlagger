@Test public void should_pass_if_actual_is_sorted_in_ascending_order_according_to_custom_comparison_strategy(){
  actual=arrayOf(1.0,-2.0,3.0,-4.0,4.0);
  arraysWithCustomComparisonStrategy.assertIsSorted(someInfo(),actual);
}
