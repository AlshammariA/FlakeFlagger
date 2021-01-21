@Test public void should_fail_if_actual_is_equal_to_other_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    doublesWithAbsValueComparisonStrategy.assertLessThan(info,6d,-6d);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeLess(6d,-6d,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
