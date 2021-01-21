@Test public void should_fail_if_actual_is_not_strictly_after_given_date(){
  AssertionInfo info=someInfo();
  Date other=parseDate("2022-01-01");
  try {
    dates.assertIsAfterOrEqualsTo(info,actual,other);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeAfterOrEqualsTo(actual,other));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
