@Test public void should_pass_if_floats_are_not_equal_according_to_custom_comparison_strategy(){
  floatsWithAbsValueComparisonStrategy.assertNotEqual(someInfo(),8f,6f);
}
