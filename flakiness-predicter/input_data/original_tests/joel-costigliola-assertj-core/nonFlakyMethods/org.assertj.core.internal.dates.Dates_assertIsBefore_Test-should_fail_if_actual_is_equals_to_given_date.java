@Test public void should_fail_if_actual_is_equals_to_given_date(){
  AssertionInfo info=someInfo();
  Date other=parseDate("2011-01-01");
  try {
    dates.assertIsBefore(info,actual,other);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeBefore(actual,other));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
