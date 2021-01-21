@Test public void should_fail_if_floats_are_equal_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    floatsWithAbsValueComparisonStrategy.assertNotEqual(info,6f,-6f);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotBeEqual(6f,-6f,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
