@Test public void should_fail_if_actual_is_today(){
  AssertionInfo info=someInfo();
  try {
    actual=new Date();
    dates.assertIsInTheFuture(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeInTheFuture(actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
