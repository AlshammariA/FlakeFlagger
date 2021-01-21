@Test public void should_fail_if_big_decimals_are_not_equal_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    bigDecimalsWithComparatorComparisonStrategy.assertEqual(info,TEN,ONE);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual(TEN,ONE,comparatorComparisonStrategy,new StandardRepresentation()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
