@Test public void should_pass_if_actual_is_in_same_hour_as_given_date(){
  dates.assertIsInSameHourAs(someInfo(),actual,parseDatetime("2011-01-01T03:59:02"));
}
