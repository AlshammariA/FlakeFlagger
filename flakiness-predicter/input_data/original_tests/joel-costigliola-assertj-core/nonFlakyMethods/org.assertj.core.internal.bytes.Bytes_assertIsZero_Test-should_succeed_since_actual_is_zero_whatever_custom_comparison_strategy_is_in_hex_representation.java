@Test public void should_succeed_since_actual_is_zero_whatever_custom_comparison_strategy_is_in_hex_representation(){
  bytesWithAbsValueComparisonStrategy.assertIsZero(someHexInfo(),(byte)0x00);
}
