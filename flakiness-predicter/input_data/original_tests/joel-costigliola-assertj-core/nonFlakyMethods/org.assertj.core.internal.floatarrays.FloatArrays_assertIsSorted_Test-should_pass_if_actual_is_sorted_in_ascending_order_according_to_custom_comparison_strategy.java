@Test public void should_pass_if_actual_is_sorted_in_ascending_order_according_to_custom_comparison_strategy(){
  actual=arrayOf(-1.0f,2.0f,-3.0f,4.0f,-4.0f);
  arraysWithCustomComparisonStrategy.assertIsSorted(someInfo(),actual);
}
