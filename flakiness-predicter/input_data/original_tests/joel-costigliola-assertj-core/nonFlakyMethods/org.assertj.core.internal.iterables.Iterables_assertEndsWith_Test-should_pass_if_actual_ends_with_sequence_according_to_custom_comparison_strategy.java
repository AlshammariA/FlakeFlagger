@Test public void should_pass_if_actual_ends_with_sequence_according_to_custom_comparison_strategy(){
  iterablesWithCaseInsensitiveComparisonStrategy.assertEndsWith(someInfo(),actual,array("luke","LEIA","Obi-Wan"));
}
