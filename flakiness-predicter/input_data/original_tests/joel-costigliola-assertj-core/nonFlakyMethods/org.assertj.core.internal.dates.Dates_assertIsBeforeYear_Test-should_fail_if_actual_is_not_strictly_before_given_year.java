@Test public void should_fail_if_actual_is_not_strictly_before_given_year(){
  AssertionInfo info=someInfo();
  int year=2010;
  try {
    dates.assertIsBeforeYear(info,actual,year);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeBeforeYear(actual,year));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
