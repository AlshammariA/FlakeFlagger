@Test public void should_fail_if_actual_contains_value_at_index(){
  AssertionInfo info=someInfo();
  short value=6;
  Index index=atIndex(0);
  try {
    arrays.assertDoesNotContain(info,actual,value,index);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotContainAtIndex(actual,value,index));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
