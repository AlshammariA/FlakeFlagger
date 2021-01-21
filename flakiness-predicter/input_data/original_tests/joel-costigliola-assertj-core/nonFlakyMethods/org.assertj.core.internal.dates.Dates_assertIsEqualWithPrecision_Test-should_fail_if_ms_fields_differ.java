@Test public void should_fail_if_ms_fields_differ(){
  AssertionInfo info=someInfo();
  Date other=parseDatetimeWithMs("2011-09-27T12:23:35.998");
  try {
    dates.assertIsEqualWithPrecision(info,actual,other,TimeUnit.MICROSECONDS);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual(actual,other,TimeUnit.MICROSECONDS));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
