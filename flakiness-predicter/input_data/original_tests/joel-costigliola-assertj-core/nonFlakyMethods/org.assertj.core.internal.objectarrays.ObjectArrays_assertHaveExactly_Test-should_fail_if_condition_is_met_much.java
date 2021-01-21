@Test public void should_fail_if_condition_is_met_much(){
  testCondition.shouldMatch(false);
  AssertionInfo info=someInfo();
  try {
    actual=array("Yoda","Luke","Obiwan");
    arrays.assertHaveExactly(someInfo(),actual,2,jediPower);
  }
 catch (  AssertionError e) {
    verify(conditions).assertIsNotNull(jediPower);
    verify(failures).failure(info,elementsShouldHaveExactly(actual,2,jediPower));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
