@Test public void should_fail_if_actual_has_only_one_non_comparable_element(){
  AssertionInfo info=someInfo();
  List<Object> actual=newArrayList(new Object());
  try {
    lists.assertIsSorted(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldHaveMutuallyComparableElements(actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
