@Test public void should_fail_if_actual_is_equal_to_other_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    floatsWithAbsValueComparisonStrategy.assertLessThan(info,6f,-6f);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeLess(6f,-6f,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
