@Test public void should_fail_if_actual_is_equal_to_other_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    longsWithAbsValueComparisonStrategy.assertLessThan(info,6L,-6L);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeLess(6L,-6L,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
