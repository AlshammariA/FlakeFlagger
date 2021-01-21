@Test public void should_pass_if_day_not_equal(){
  AssertionInfo info=someInfo();
  Date other=parseDatetimeWithMs("2011-09-28T12:23:35.999");
  dates.assertIsEqualWithPrecision(info,actual,other,TimeUnit.DAYS);
}
