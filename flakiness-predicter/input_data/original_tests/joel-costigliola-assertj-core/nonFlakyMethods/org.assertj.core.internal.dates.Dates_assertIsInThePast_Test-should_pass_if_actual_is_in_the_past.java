@Test public void should_pass_if_actual_is_in_the_past(){
  actual=parseDate("2000-01-01");
  dates.assertIsInThePast(someInfo(),actual);
}
