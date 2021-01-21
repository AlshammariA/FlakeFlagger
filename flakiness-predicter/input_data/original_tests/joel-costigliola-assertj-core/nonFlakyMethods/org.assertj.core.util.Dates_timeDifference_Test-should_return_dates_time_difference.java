@Test public void should_return_dates_time_difference() throws ParseException {
  final Date date1=parseDatetimeWithMs("2003-04-26T03:01:02.999");
  final Date date2=parseDatetimeWithMs("2003-04-26T03:01:02.888");
  assertThat(timeDifference(date1,date2)).isEqualTo(111);
  assertThat(timeDifference(date2,date1)).isEqualTo(timeDifference(date1,date2));
}
