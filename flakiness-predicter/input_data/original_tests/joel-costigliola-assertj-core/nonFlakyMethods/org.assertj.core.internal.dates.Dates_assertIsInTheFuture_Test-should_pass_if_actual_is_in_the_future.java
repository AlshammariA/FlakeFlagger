@Test public void should_pass_if_actual_is_in_the_future(){
  actual=parseDate("2111-01-01");
  dates.assertIsInTheFuture(someInfo(),actual);
}
