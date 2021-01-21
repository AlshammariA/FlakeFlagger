@Test public void should_fail_if_actual_is_not_close_to_given_date_by_less_than_given_delta(){
  AssertionInfo info=someInfo();
  try {
    dates.assertIsCloseTo(info,actual,other,delta);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeCloseTo(actual,other,delta,101));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
