@Test public void should_fail_if_actual_is_not_sorted_according_to_given_comparator(){
  AssertionInfo info=someInfo();
  List<String> actual=newArrayList("Yoda","Vador","Leia","Leia","Luke");
  try {
    lists.assertIsSortedAccordingToComparator(info,actual,stringDescendingOrderComparator);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeSortedAccordingToGivenComparator(3,actual,stringDescendingOrderComparator));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
