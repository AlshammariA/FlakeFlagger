@Test public void should_pass_if_actual_contains_sequence_according_to_custom_comparison_strategy(){
  iterablesWithCaseInsensitiveComparisonStrategy.assertContainsSequence(someInfo(),actual,array("LUKe","leia"));
}
