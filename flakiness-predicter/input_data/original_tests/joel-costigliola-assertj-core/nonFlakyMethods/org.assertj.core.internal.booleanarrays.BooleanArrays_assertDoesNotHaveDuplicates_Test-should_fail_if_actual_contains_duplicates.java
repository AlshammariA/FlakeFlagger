@Test public void should_fail_if_actual_contains_duplicates(){
  actual=arrayOf(true,true,false);
  AssertionInfo info=someInfo();
  try {
    arrays.assertDoesNotHaveDuplicates(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotHaveDuplicates(actual,newLinkedHashSet(true)));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
