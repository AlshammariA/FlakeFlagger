@Test public void should_verify_that_date_has_same_time_as_string_from_date() throws ParseException {
  Date date=parseDatetime("2003-04-26T12:00:00");
  assertThat(date).hasSameTimeAs("2003-04-26T12:00:00");
}
