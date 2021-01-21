@Test public void should_fail_if_actual_is_greater_than_other_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    floatsWithAbsValueComparisonStrategy.assertLessThanOrEqualTo(info,-8f,6f);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeLessOrEqual(-8f,6f,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
