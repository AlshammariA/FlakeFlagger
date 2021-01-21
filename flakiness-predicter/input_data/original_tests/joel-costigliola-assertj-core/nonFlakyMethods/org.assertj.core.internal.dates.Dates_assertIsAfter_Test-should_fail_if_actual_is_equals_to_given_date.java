@Test public void should_fail_if_actual_is_equals_to_given_date(){
  AssertionInfo info=someInfo();
  Date other=parseDate("2011-01-15");
  try {
    dates.assertIsAfter(info,actual,other);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeAfter(actual,other));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
