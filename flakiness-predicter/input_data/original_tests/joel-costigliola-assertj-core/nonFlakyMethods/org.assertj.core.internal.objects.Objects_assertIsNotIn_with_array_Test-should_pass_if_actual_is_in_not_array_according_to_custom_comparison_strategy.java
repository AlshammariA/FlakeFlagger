@Test public void should_pass_if_actual_is_in_not_array_according_to_custom_comparison_strategy(){
  objectsWithCustomComparisonStrategy.assertIsNotIn(someInfo(),"Luke",values);
}
