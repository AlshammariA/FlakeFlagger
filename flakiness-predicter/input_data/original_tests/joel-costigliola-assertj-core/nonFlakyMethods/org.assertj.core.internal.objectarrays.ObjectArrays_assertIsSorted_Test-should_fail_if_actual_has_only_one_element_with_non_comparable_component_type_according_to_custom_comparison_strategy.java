@Test public void should_fail_if_actual_has_only_one_element_with_non_comparable_component_type_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  Object[] actual=array(new Object());
  try {
    arraysWithCustomComparisonStrategy.assertIsSorted(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldHaveComparableElementsAccordingToGivenComparator(actual,comparatorForCustomComparisonStrategy()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
