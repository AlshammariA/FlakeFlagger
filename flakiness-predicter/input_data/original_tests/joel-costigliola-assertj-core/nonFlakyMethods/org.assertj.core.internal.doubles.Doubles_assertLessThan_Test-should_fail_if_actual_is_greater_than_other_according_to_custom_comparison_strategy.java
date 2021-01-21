@Test public void should_fail_if_actual_is_greater_than_other_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    doublesWithAbsValueComparisonStrategy.assertLessThan(info,-8d,6d);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeLess(-8d,6d,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
