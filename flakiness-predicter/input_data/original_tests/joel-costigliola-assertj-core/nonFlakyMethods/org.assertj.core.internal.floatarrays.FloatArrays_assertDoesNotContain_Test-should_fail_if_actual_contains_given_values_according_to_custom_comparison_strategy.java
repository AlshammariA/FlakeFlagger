@Test public void should_fail_if_actual_contains_given_values_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  float[] expected={6f,-8f,20f};
  try {
    arraysWithCustomComparisonStrategy.assertDoesNotContain(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotContain(actual,expected,newLinkedHashSet(6f,-8f),absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
