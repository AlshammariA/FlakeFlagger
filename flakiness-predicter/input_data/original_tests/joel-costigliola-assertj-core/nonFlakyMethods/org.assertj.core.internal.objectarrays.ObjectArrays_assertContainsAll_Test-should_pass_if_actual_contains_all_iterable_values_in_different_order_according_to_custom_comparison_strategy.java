@Test public void should_pass_if_actual_contains_all_iterable_values_in_different_order_according_to_custom_comparison_strategy(){
  arraysWithCustomComparisonStrategy.assertContainsAll(someInfo(),actual,newArrayList("LEIa","YodA"));
}
