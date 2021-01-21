@Test public void should_fail_if_condition_is_met_much(){
  testCondition.shouldMatch(false);
  AssertionInfo info=someInfo();
  try {
    actual=newArrayList("Yoda","Luke","Obiwan");
    iterables.assertHaveExactly(someInfo(),actual,2,jediPower);
  }
 catch (  AssertionError e) {
    verify(conditions).assertIsNotNull(jediPower);
    verify(failures).failure(info,elementsShouldHaveExactly(actual,2,jediPower));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
