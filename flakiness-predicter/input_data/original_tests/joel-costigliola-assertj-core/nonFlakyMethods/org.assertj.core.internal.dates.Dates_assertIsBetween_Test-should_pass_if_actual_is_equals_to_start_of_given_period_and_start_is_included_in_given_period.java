@Test public void should_pass_if_actual_is_equals_to_start_of_given_period_and_start_is_included_in_given_period(){
  actual=parseDate("2011-09-01");
  Date start=parseDate("2011-09-01");
  Date end=parseDate("2011-09-30");
  dates.assertIsBetween(someInfo(),actual,start,end,true,false);
  dates.assertIsBetween(someInfo(),actual,start,end,true,true);
}
