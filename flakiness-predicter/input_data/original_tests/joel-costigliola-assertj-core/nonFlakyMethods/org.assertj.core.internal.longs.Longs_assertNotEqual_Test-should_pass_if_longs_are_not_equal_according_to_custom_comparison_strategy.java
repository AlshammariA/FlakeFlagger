@Test public void should_pass_if_longs_are_not_equal_according_to_custom_comparison_strategy(){
  longsWithAbsValueComparisonStrategy.assertNotEqual(someInfo(),8L,6L);
}
