@Test public void should_fail_if_actual_is_not_sorted_in_ascending_order(){
  AssertionInfo info=someInfo();
  actual=newArrayList("Luke","Yoda","Leia");
  try {
    lists.assertIsSorted(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeSorted(1,actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
