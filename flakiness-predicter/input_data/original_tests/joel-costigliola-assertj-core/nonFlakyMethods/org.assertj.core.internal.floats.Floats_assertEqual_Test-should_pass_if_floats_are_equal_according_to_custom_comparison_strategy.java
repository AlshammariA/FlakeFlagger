@Test public void should_pass_if_floats_are_equal_according_to_custom_comparison_strategy(){
  floatsWithAbsValueComparisonStrategy.assertEqual(someInfo(),-8f,8f);
}
