@Test public void should_pass_if_big_decimals_are_equal_by_comparison_whatever_custom_comparison_strategy_is(){
  bigDecimalsWithAbsValueComparisonStrategy.assertIsCloseTo(someInfo(),new BigDecimal("5.0"),new BigDecimal("5"),offset(ONE));
}
