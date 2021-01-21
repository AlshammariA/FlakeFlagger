@Test public void should_fail_if_actual_has_some_non_comparable_elements(){
  AssertionInfo info=someInfo();
  List<Object> actual=newArrayList("bar",new Object(),"foo");
  try {
    lists.assertIsSorted(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldHaveMutuallyComparableElements(actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
