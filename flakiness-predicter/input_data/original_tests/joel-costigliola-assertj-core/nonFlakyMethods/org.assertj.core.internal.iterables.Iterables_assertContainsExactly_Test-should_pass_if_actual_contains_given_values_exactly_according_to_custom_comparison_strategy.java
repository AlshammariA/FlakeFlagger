@Test public void should_pass_if_actual_contains_given_values_exactly_according_to_custom_comparison_strategy(){
  iterablesWithCaseInsensitiveComparisonStrategy.assertContainsExactly(someInfo(),actual,array("LUKE","YODA","Leia"));
}
