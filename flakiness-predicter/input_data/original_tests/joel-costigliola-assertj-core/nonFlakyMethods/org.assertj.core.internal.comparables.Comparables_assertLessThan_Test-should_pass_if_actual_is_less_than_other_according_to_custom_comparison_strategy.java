@Test public void should_pass_if_actual_is_less_than_other_according_to_custom_comparison_strategy(){
  comparablesWithCustomComparisonStrategy.assertLessThan(someInfo(),6,8);
}
