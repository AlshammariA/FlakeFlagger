@Test public void should_fail_if_actual_is_equal_to_other_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    comparablesWithCustomComparisonStrategy.assertLessThan(info,-7,7);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeLess(-7,7,customComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
