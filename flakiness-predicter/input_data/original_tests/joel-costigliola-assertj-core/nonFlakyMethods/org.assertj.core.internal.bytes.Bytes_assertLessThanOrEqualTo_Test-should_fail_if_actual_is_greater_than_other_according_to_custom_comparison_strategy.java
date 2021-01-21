@Test public void should_fail_if_actual_is_greater_than_other_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    bytesWithAbsValueComparisonStrategy.assertLessThanOrEqualTo(info,(byte)-8,(byte)6);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeLessOrEqual((byte)-8,(byte)6,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
