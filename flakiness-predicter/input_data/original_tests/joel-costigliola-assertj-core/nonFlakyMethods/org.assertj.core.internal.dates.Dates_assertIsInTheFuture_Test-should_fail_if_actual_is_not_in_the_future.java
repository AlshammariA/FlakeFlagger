@Test public void should_fail_if_actual_is_not_in_the_future(){
  AssertionInfo info=someInfo();
  try {
    dates.assertIsInTheFuture(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeInTheFuture(actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
