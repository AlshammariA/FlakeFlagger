@Test public void should_fail_if_actual_is_less_than_other_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    bytesWithAbsValueComparisonStrategy.assertGreaterThan(info,(byte)-6,(byte)8);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeGreater((byte)-6,(byte)8,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
