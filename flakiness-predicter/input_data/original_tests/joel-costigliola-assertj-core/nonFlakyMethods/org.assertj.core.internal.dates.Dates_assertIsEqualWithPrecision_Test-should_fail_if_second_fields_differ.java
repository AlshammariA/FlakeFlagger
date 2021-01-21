@Test public void should_fail_if_second_fields_differ(){
  AssertionInfo info=someInfo();
  Date other=parseDatetimeWithMs("2011-09-27T12:23:36.999");
  try {
    dates.assertIsEqualWithPrecision(info,actual,other,TimeUnit.MILLISECONDS);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual(actual,other,TimeUnit.MILLISECONDS));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
