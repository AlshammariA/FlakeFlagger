@Test public void should_fail_if_condition_is_not_met_enought(){
  testCondition.shouldMatch(false);
  AssertionInfo info=someInfo();
  try {
    actual=array("Yoda","Solo","Leia");
    arrays.assertHaveExactly(someInfo(),actual,2,jediPower);
  }
 catch (  AssertionError e) {
    verify(conditions).assertIsNotNull(jediPower);
    verify(failures).failure(info,elementsShouldHaveExactly(actual,2,jediPower));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
