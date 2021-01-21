@Test public void should_fail_if_actual_is_equal_to_other_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    bytesWithAbsValueComparisonStrategy.assertLessThan(info,(byte)6,(byte)-6);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeLess((byte)6,(byte)-6,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
