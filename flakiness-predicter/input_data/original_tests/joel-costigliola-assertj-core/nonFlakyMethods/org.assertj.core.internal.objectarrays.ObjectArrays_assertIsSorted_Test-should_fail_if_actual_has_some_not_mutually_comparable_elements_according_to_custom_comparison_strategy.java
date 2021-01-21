@Test public void should_fail_if_actual_has_some_not_mutually_comparable_elements_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  Object[] actual=new Object[]{"bar",new Integer(5),"foo"};
  try {
    arraysWithCustomComparisonStrategy.assertIsSorted(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldHaveComparableElementsAccordingToGivenComparator(actual,comparatorForCustomComparisonStrategy()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
