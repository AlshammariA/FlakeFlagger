@Test public void should_fail_if_minute_fields_differ(){
  AssertionInfo info=someInfo();
  Date other=parseDatetimeWithMs("2011-09-27T12:24:35.999");
  try {
    dates.assertIsEqualWithPrecision(info,actual,other,TimeUnit.SECONDS);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual(actual,other,TimeUnit.SECONDS));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
