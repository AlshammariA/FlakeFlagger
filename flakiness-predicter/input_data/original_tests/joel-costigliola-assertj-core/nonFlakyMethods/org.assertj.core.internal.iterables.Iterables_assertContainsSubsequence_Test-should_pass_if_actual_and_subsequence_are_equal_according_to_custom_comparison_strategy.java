@Test public void should_pass_if_actual_and_subsequence_are_equal_according_to_custom_comparison_strategy(){
  iterablesWithCaseInsensitiveComparisonStrategy.assertContainsSubsequence(someInfo(),actual,array("YODA","luke","lEIA","Obi-wan"));
}
