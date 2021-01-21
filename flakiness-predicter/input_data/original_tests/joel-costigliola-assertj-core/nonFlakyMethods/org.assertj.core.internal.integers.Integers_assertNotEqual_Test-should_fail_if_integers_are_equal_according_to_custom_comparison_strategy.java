@Test public void should_fail_if_integers_are_equal_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    integersWithAbsValueComparisonStrategy.assertNotEqual(info,6,-6);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotBeEqual(6,-6,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
