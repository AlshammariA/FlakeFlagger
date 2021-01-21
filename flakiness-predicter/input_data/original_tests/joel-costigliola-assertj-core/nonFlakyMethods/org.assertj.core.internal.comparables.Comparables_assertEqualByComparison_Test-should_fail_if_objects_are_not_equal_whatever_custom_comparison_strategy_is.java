@Test public void should_fail_if_objects_are_not_equal_whatever_custom_comparison_strategy_is(){
  AssertionInfo info=someInfo();
  try {
    comparablesWithCustomComparisonStrategy.assertEqualByComparison(info,"Luke","Yoda");
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual("Luke","Yoda",info.representation()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
