@Test public void should_pass_if_doubles_are_not_equal_according_to_custom_comparison_strategy(){
  doublesWithAbsValueComparisonStrategy.assertNotEqual(someInfo(),8d,6d);
}
