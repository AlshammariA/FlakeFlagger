@Test public void should_fail_if_actual_is_not_strictly_after_given_year(){
  AssertionInfo info=someInfo();
  int year=2020;
  try {
    dates.assertIsAfterYear(info,actual,year);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeAfterYear(actual,year));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
