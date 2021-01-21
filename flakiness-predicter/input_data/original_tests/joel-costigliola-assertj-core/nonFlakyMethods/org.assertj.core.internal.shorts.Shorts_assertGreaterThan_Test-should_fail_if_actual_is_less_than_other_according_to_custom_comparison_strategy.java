@Test public void should_fail_if_actual_is_less_than_other_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    shortsWithAbsValueComparisonStrategy.assertGreaterThan(info,(short)-6,(short)8);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeGreater((short)-6,(short)8,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
