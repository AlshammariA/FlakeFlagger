@Test public void should_return_dates_time_difference() throws ParseException {
  final Date date1=parseDatetimeWithMs("2003-01-01T00:00:00.888");
  assertThat(formatTimeDifference(date1,parseDatetimeWithMs("2003-01-01T00:00:00.999"))).isEqualTo("111ms");
  assertThat(formatTimeDifference(date1,parseDatetimeWithMs("2003-01-01T00:00:01.999"))).isEqualTo("1s and 111ms");
  assertThat(formatTimeDifference(date1,parseDatetimeWithMs("2003-01-01T00:00:01.888"))).isEqualTo("1s");
  assertThat(formatTimeDifference(date1,parseDatetimeWithMs("2003-01-01T00:02:01.999"))).isEqualTo("2m 1s and 111ms");
  assertThat(formatTimeDifference(date1,parseDatetimeWithMs("2003-01-01T00:02:00.999"))).isEqualTo("2m and 111ms");
  assertThat(formatTimeDifference(date1,parseDatetimeWithMs("2003-01-01T03:02:01.999"))).isEqualTo("3h 2m 1s and 111ms");
  assertThat(formatTimeDifference(date1,parseDatetimeWithMs("2003-01-01T03:02:00.888"))).isEqualTo("3h and 2m");
  assertThat(formatTimeDifference(date1,parseDatetimeWithMs("2003-01-05T03:02:01.999"))).isEqualTo("4d 3h 2m 1s and 111ms");
  assertThat(formatTimeDifference(date1,parseDatetimeWithMs("2003-02-01T03:02:01.999"))).isEqualTo("31d 3h 2m 1s and 111ms");
  assertThat(formatTimeDifference(date1,parseDatetimeWithMs("2003-01-01T03:02:01.888"))).isEqualTo("3h 2m and 1s");
  assertThat(formatTimeDifference(date1,parseDatetimeWithMs("2003-02-01T00:02:00.999"))).isEqualTo("31d 2m and 111ms");
  assertThat(formatTimeDifference(date1,parseDatetimeWithMs("2003-02-01T00:02:00.888"))).isEqualTo("31d and 2m");
  assertThat(formatTimeDifference(date1,parseDatetimeWithMs("2003-02-01T01:00:00.888"))).isEqualTo("31d and 1h");
  assertThat(formatTimeDifference(date1,parseDatetimeWithMs("2003-02-01T00:00:00.999"))).isEqualTo("31d and 111ms");
  final Date date3=parseDatetimeWithMs("2008-07-06T05:04:03.002");
  assertThat(formatTimeDifference(date3,parseDatetimeWithMs("2008-07-06T05:04:03.002"))).isEmpty();
  assertThat(formatTimeDifference(date3,parseDatetimeWithMs("2008-07-06T05:04:03.001"))).isEqualTo("1ms");
  assertThat(formatTimeDifference(date3,parseDatetimeWithMs("2008-07-01T04:03:02.001"))).isEqualTo("5d 1h 1m 1s and 1ms");
}
