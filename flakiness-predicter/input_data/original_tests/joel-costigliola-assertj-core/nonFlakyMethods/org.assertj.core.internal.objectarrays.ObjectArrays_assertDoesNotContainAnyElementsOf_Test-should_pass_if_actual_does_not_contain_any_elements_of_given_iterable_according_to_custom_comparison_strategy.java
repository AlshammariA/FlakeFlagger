@Test public void should_pass_if_actual_does_not_contain_any_elements_of_given_iterable_according_to_custom_comparison_strategy(){
  arraysWithCustomComparisonStrategy.assertDoesNotContainAnyElementsOf(someInfo(),actual,newArrayList("Han"));
}
