@Test public void should_pass_if_actual_contains_given_values_in_different_order_according_to_custom_comparison_strategy(){
  iterablesWithCaseInsensitiveComparisonStrategy.assertContains(someInfo(),actual,array("LEIA","yODa"));
}
