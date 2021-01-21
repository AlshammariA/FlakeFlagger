@Test public void should_fail_if_actual_is_not_today(){
  AssertionInfo info=someInfo();
  try {
    actual=parseDate("2111-01-01");
    dates.assertIsToday(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeToday(actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
