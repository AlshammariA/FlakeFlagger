@Test public void should_fail_if_actual_is_less_than_other_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    bigDecimalsWithAbsValueComparisonStrategy.assertLessThanOrEqualTo(info,TEN.negate(),ONE);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeLessOrEqual(TEN.negate(),ONE,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
