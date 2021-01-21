@Test public void should_fail_if_actual_is_greater_than_other_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    longsWithAbsValueComparisonStrategy.assertLessThanOrEqualTo(info,-8L,6L);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeLessOrEqual(-8L,6L,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
