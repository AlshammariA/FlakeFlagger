@Test public void should_pass_if_actual_contains_value_at_index_according_to_custom_comparison_strategy(){
  listsWithCaseInsensitiveComparisonStrategy.assertContains(someInfo(),actual,"Luke",atIndex(1));
  listsWithCaseInsensitiveComparisonStrategy.assertContains(someInfo(),actual,"luke",atIndex(1));
  listsWithCaseInsensitiveComparisonStrategy.assertContains(someInfo(),actual,"LUKE",atIndex(1));
}
