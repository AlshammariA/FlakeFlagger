@Test public void should_fail_if_actual_is_less_than_other_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    bigDecimalsWithAbsValueComparisonStrategy.assertLessThan(info,TEN.negate(),ONE);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeLess(TEN.negate(),ONE,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
