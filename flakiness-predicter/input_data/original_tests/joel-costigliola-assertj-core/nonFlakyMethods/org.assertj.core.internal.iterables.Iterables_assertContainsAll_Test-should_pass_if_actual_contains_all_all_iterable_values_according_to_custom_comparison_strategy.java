@Test public void should_pass_if_actual_contains_all_all_iterable_values_according_to_custom_comparison_strategy(){
  iterablesWithCaseInsensitiveComparisonStrategy.assertContainsAll(someInfo(),actual,newArrayList("luke","YODA"));
}
