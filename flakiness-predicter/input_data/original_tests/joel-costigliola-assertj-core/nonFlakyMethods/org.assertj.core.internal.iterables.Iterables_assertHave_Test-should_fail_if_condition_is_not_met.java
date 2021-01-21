@Test public void should_fail_if_condition_is_not_met(){
  testCondition.shouldMatch(false);
  AssertionInfo info=someInfo();
  try {
    actual=newArrayList("Yoda","Luke","Leia");
    iterables.assertHave(someInfo(),actual,jediPower);
  }
 catch (  AssertionError e) {
    verify(conditions).assertIsNotNull(jediPower);
    verify(failures).failure(info,elementsShouldHave(actual,newArrayList("Leia"),jediPower));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
