@Test public void should_pass_if_integers_are_not_equal_according_to_custom_comparison_strategy(){
  integersWithAbsValueComparisonStrategy.assertNotEqual(someInfo(),8,6);
}
