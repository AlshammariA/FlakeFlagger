@Test public void should_fail_if_bytes_are_equal_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    bytesWithAbsValueComparisonStrategy.assertNotEqual(info,(byte)6,(byte)-6);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotBeEqual((byte)6,(byte)-6,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
