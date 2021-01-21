@Test public void should_fail_if_actual_has_some_not_mutually_comparable_elements(){
  AssertionInfo info=someInfo();
  List<Object> actual=newArrayList();
  actual.add("bar");
  actual.add(new Integer(5));
  actual.add("foo");
  try {
    lists.assertIsSorted(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldHaveMutuallyComparableElements(actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
