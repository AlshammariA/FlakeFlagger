@Test public void should_pass_if_actual_starts_with_sequence_according_to_custom_comparison_strategy(){
  iterablesWithCaseInsensitiveComparisonStrategy.assertStartsWith(someInfo(),actual,array("YODA","luke","Leia"));
}
