@Test public void should_pass_if_actual_contains_given_values_only_once_in_different_order_according_to_custom_comparison_strategy(){
  iterablesWithCaseInsensitiveComparisonStrategy.assertContainsOnlyOnce(someInfo(),actual,array("LEIA","yoda","LukE"));
}
