@Test public void should_pass_if_actual_is_in_same_second_as_given_date(){
  Date other=parseDatetime("2011-01-01T03:15:05");
  dates.assertIsInSameSecondAs(someInfo(),actual,other);
  dates.assertIsInSameSecondAs(someInfo(),actual,new Date(other.getTime() + 999));
}
