@Test public void should_throw_error_if_end_date_is_null(){
  thrown.expectNullPointerException(endDateToCompareActualWithIsNull());
  Date start=parseDate("2011-09-01");
  dates.assertIsNotBetween(someInfo(),actual,start,null,true,true);
}
