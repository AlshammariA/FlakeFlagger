@Test public void should_verify_that_date_has_time_same_as_string_from_timestamp(){
  Date date=parseDatetime("2003-04-26T12:59:59.999");
  Timestamp timestamp=new Timestamp(date.getTime());
  assertThat(date).withDateFormat("yyyy-MM-dd HH:mm:ss.SSS").hasSameTimeAs(timestamp.toString());
}
