@Test public void should_fail_if_actual_contains_null(){
  AssertionInfo info=someInfo();
  actual=array("Luke","Yoda",null);
  try {
    arrays.assertDoesNotContainNull(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotContainNull(actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
