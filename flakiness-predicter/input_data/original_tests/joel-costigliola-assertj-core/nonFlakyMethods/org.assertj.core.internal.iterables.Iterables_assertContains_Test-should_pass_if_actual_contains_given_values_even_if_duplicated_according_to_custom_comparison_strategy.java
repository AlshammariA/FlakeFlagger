@Test public void should_pass_if_actual_contains_given_values_even_if_duplicated_according_to_custom_comparison_strategy(){
  iterablesWithCaseInsensitiveComparisonStrategy.assertContains(someInfo(),actual,array("LUke","LuKe"));
}
