@Test public void should_pass_if_actual_is_empty_with_comparable_component_type_according_to_custom_comparison_strategy(){
  arraysWithCustomComparisonStrategy.assertIsSorted(someInfo(),new String[0]);
}
