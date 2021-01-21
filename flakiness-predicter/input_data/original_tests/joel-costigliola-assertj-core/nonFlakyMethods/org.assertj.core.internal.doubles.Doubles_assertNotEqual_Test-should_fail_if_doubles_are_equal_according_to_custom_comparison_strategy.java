@Test public void should_fail_if_doubles_are_equal_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    doublesWithAbsValueComparisonStrategy.assertNotEqual(info,6d,-6d);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotBeEqual(6d,-6d,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
