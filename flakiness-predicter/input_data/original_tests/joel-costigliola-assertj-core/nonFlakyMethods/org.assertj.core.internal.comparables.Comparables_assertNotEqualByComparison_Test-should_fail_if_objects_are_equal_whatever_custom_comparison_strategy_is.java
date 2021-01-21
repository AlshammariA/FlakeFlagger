@Test public void should_fail_if_objects_are_equal_whatever_custom_comparison_strategy_is(){
  AssertionInfo info=someInfo();
  try {
    comparablesWithCustomComparisonStrategy.assertNotEqualByComparison(info,new Person("Yoda"),new Person("Yoda"));
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotBeEqual(new Person("Yoda"),new Person("Yoda")));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
