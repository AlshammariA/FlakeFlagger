@Test public void should_throw_error_if_start_date_is_null(){
  thrown.expectNullPointerException(startDateToCompareActualWithIsNull());
  Date end=parseDate("2011-09-30");
  dates.assertIsNotBetween(someInfo(),actual,null,end,true,true);
}
