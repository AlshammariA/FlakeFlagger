@Test public void should_fail_if_shorts_are_equal_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    shortsWithAbsValueComparisonStrategy.assertNotEqual(info,(short)6,(short)-6);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotBeEqual((short)6,(short)-6,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
