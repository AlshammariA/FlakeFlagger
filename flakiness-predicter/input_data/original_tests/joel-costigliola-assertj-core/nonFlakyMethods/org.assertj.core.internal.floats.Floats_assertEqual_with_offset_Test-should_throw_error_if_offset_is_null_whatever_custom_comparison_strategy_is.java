@Test public void should_throw_error_if_offset_is_null_whatever_custom_comparison_strategy_is(){
  thrown.expectNullPointerException(offsetIsNull());
  floatsWithAbsValueComparisonStrategy.assertEqual(someInfo(),new Float(8f),new Float(8f),null);
}
