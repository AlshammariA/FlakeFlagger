@Test public void should_fail_if_actual_contains_duplicates(){
  AssertionInfo info=someInfo();
  actual=arrayOf(6L,8L,6L,8L);
  try {
    arrays.assertDoesNotHaveDuplicates(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotHaveDuplicates(actual,newLinkedHashSet(6L,8L)));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
