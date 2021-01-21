@Test public void should_pass_regardless_of_second_and_millisecond_fields_values(){
  AssertionInfo info=someInfo();
  Date other=parseDatetimeWithMs("2011-09-27T12:23:36.999");
  dates.assertIsEqualWithPrecision(info,actual,other,TimeUnit.SECONDS);
}
