@Test public void should_fail_if_actual_is_not_strictly_before_given_date(){
  AssertionInfo info=someInfo();
  Date other=parseDate("2000-01-01");
  try {
    dates.assertIsBefore(info,actual,other);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeBefore(actual,other));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
