@Test public void should_pass_if_longs_are_equal_according_to_custom_comparison_strategy(){
  longsWithAbsValueComparisonStrategy.assertEqual(someInfo(),8L,-8L);
}
