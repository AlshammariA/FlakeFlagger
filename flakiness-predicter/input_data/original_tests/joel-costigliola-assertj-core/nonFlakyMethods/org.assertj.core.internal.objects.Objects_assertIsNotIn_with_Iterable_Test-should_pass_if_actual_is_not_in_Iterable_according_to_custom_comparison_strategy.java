@Test public void should_pass_if_actual_is_not_in_Iterable_according_to_custom_comparison_strategy(){
  objectsWithCustomComparisonStrategy.assertIsNotIn(someInfo(),"Luke",values);
}
