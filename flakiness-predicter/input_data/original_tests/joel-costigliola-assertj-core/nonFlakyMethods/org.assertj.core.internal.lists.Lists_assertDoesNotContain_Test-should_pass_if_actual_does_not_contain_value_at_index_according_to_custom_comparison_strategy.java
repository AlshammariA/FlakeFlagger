@Test public void should_pass_if_actual_does_not_contain_value_at_index_according_to_custom_comparison_strategy(){
  listsWithCaseInsensitiveComparisonStrategy.assertDoesNotContain(someInfo(),actual,"Yoda",atIndex(1));
}
