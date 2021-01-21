@Test public void should_fail_if_actual_year_is_equals_to_given_year(){
  AssertionInfo info=someInfo();
  parseDate("2011-01-01");
  int year=2011;
  try {
    dates.assertIsAfterYear(info,actual,year);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeAfterYear(actual,year));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
