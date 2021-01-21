@Test public void should_fail_if_actual_is_greater_than_other_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    shortsWithAbsValueComparisonStrategy.assertLessThanOrEqualTo(info,(short)-8,(short)6);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeLessOrEqual((short)-8,(short)6,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
