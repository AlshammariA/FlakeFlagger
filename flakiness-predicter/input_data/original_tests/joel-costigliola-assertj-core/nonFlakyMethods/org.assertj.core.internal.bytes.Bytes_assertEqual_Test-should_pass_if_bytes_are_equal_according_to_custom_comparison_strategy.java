@Test public void should_pass_if_bytes_are_equal_according_to_custom_comparison_strategy(){
  bytesWithAbsValueComparisonStrategy.assertEqual(someInfo(),(byte)8,(byte)-8);
}
