@Test public void should_pass_if_doubles_are_equal_according_to_custom_comparison_strategy(){
  doublesWithAbsValueComparisonStrategy.assertEqual(someInfo(),8d,-8d);
}
