@Test public void should_fail_if_actual_is_not_in_same_year_as_given_date(){
  AssertionInfo info=someInfo();
  Date other=parseDate("2000-01-01");
  try {
    dates.assertIsInSameYearAs(info,actual,other);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeInSameYear(actual,other));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
