@Test public void should_pass_if_actual_is_equals_to_end_of_given_period_and_end_is_not_included_in_given_period(){
  actual=parseDate("2011-09-30");
  Date start=parseDate("2011-09-01");
  Date end=parseDate("2011-09-30");
  dates.assertIsNotBetween(someInfo(),actual,start,end,false,false);
  dates.assertIsNotBetween(someInfo(),actual,start,end,true,false);
}
