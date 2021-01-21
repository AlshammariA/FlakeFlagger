@Test public void should_fail_if_longs_are_equal_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    longsWithAbsValueComparisonStrategy.assertNotEqual(info,-6L,6L);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotBeEqual(-6L,6L,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
