@Test public void should_pass_if_bytes_are_not_equal_according_to_custom_comparison_strategy(){
  bytesWithAbsValueComparisonStrategy.assertNotEqual(someInfo(),(byte)8,(byte)6);
}
