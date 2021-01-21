@Test public void should_pass_regardless_of_millisecond_fields_values(){
  AssertionInfo info=someInfo();
  Date other=parseDatetimeWithMs("2011-09-27T12:23:35.998");
  dates.assertIsEqualWithPrecision(info,actual,other,TimeUnit.MILLISECONDS);
}
