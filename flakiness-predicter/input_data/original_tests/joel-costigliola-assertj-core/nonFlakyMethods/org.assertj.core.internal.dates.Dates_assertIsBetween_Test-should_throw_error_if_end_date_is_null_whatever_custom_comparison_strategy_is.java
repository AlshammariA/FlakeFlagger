@Test public void should_throw_error_if_end_date_is_null_whatever_custom_comparison_strategy_is(){
  thrown.expectNullPointerException(endDateToCompareActualWithIsNull());
  Date start=parseDate("2011-09-01");
  datesWithCustomComparisonStrategy.assertIsBetween(someInfo(),actual,start,null,true,true);
}
