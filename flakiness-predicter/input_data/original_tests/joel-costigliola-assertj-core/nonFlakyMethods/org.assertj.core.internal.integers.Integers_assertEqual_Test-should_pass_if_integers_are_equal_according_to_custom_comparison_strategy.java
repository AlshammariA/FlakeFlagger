@Test public void should_pass_if_integers_are_equal_according_to_custom_comparison_strategy(){
  integersWithAbsValueComparisonStrategy.assertEqual(someInfo(),8,-8);
}
