@Test public void should_pass_if_actual_contains_given_values_only_even_if_duplicated_according_to_custom_comparison_strategy(){
  actual.addAll(newArrayList("LUKE"));
  iterablesWithCaseInsensitiveComparisonStrategy.assertContainsOnly(someInfo(),actual,array("LUke","LUke","lukE","YOda","Leia"));
}
