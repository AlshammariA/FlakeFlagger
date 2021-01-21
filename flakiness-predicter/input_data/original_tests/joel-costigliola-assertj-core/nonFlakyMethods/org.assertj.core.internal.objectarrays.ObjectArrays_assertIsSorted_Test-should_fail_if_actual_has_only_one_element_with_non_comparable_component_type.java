@Test public void should_fail_if_actual_has_only_one_element_with_non_comparable_component_type(){
  AssertionInfo info=someInfo();
  Object[] actual=array(new Object());
  try {
    arrays.assertIsSorted(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldHaveMutuallyComparableElements(actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
