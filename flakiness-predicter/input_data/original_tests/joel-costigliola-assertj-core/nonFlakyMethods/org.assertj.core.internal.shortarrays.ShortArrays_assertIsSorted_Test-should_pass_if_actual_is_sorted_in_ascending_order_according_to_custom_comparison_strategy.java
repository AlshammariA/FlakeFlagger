@Test public void should_pass_if_actual_is_sorted_in_ascending_order_according_to_custom_comparison_strategy(){
  actual=new short[]{1,-2,3,-4,4};
  arraysWithCustomComparisonStrategy.assertIsSorted(someInfo(),actual);
}
