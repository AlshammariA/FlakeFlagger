@Test public void should_fail_if_actual_contains_duplicates(){
  AssertionInfo info=someInfo();
  actual=arrayOf(6f,8f,6f,8f);
  try {
    arrays.assertDoesNotHaveDuplicates(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotHaveDuplicates(actual,newLinkedHashSet(6f,8f)));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
