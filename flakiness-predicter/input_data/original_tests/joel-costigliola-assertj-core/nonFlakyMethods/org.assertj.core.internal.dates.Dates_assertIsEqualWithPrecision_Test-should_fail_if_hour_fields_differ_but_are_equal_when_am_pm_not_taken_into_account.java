@Test public void should_fail_if_hour_fields_differ_but_are_equal_when_am_pm_not_taken_into_account(){
  AssertionInfo info=someInfo();
  final Date now=new Date();
  Calendar calendar1=Calendar.getInstance();
  calendar1.setTime(now);
  calendar1.set(Calendar.HOUR_OF_DAY,18);
  Calendar calendar2=Calendar.getInstance();
  calendar2.setTime(now);
  calendar2.set(Calendar.HOUR_OF_DAY,6);
  Date date1=calendar1.getTime();
  Date date2=calendar2.getTime();
  try {
    dates.assertIsEqualWithPrecision(info,date1,date2,TimeUnit.MINUTES);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual(date1,date2,TimeUnit.MINUTES));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
