@Test public void should_pass_if_big_decimals_are_equal_according_to_custom_comparison_strategy(){
  bigDecimalsWithComparatorComparisonStrategy.assertEqual(someInfo(),ONE_WITH_3_DECIMALS,ONE);
}
