@Test public void should_verify_that_actual_has_time_equals_to_expected(){
  Date date=new Date();
  Timestamp timestamp=new java.sql.Timestamp(date.getTime());
  assertThat(date).hasSameTimeAs(timestamp);
  assertThat(timestamp).hasSameTimeAs(date);
}
