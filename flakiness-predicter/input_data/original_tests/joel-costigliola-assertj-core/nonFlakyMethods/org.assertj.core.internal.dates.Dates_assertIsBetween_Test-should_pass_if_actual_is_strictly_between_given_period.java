@Test public void should_pass_if_actual_is_strictly_between_given_period(){
  Date start=parseDate("2011-09-01");
  Date end=parseDate("2011-09-30");
  dates.assertIsBetween(someInfo(),actual,start,end,false,false);
}
