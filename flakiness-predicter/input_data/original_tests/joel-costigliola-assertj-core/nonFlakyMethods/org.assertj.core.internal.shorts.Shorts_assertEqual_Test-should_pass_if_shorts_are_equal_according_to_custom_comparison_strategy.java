@Test public void should_pass_if_shorts_are_equal_according_to_custom_comparison_strategy(){
  shortsWithAbsValueComparisonStrategy.assertEqual(someInfo(),(short)8,(short)-8);
}
