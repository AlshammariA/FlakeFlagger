@Test public void should_pass_if_iterable_to_look_for_is_empty_whatever_custom_comparison_strategy_is(){
  arraysWithCustomComparisonStrategy.assertContainsAll(someInfo(),actual,newArrayList());
}
