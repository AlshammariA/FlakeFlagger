@Test public void should_pass_if_shorts_are_not_equal_according_to_custom_comparison_strategy(){
  shortsWithAbsValueComparisonStrategy.assertNotEqual(someInfo(),(short)8,(short)6);
}
