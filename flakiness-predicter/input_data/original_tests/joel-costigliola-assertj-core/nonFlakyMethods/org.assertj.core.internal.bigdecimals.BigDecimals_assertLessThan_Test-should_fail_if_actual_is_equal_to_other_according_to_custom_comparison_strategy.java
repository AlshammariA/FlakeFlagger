@Test public void should_fail_if_actual_is_equal_to_other_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    bigDecimalsWithAbsValueComparisonStrategy.assertLessThan(info,TEN.negate(),TEN);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeLess(TEN.negate(),TEN,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
