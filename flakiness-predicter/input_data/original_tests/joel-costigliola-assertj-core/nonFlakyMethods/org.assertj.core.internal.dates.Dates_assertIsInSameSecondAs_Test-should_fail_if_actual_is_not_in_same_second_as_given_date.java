@Test public void should_fail_if_actual_is_not_in_same_second_as_given_date(){
  AssertionInfo info=someInfo();
  Date other=parseDatetime("2011-01-01T03:15:02");
  try {
    dates.assertIsInSameSecondAs(info,actual,other);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeInSameSecond(actual,other));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
