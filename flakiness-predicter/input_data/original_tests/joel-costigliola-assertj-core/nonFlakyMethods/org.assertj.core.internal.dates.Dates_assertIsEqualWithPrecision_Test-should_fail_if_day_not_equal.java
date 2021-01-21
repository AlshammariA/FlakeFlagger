@Test public void should_fail_if_day_not_equal(){
  AssertionInfo info=someInfo();
  Date other=parseDatetimeWithMs("2011-09-28T12:23:35.999");
  try {
    dates.assertIsEqualWithPrecision(info,actual,other,TimeUnit.HOURS);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual(actual,other,TimeUnit.HOURS));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
