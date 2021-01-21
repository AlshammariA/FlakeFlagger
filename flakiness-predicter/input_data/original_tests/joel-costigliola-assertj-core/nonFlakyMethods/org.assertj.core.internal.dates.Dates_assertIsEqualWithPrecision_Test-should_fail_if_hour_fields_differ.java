@Test public void should_fail_if_hour_fields_differ(){
  AssertionInfo info=someInfo();
  Date other=parseDatetimeWithMs("2011-09-27T13:23:35.999");
  try {
    dates.assertIsEqualWithPrecision(info,actual,other,TimeUnit.MINUTES);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual(actual,other,TimeUnit.MINUTES));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
