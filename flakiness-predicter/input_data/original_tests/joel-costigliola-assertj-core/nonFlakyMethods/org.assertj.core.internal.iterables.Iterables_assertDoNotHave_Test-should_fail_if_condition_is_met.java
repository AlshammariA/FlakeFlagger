@Test public void should_fail_if_condition_is_met(){
  testCondition.shouldMatch(false);
  AssertionInfo info=someInfo();
  try {
    actual=newArrayList("Solo","Leia","Yoda");
    iterables.assertDoNotHave(someInfo(),actual,jediPower);
  }
 catch (  AssertionError e) {
    verify(conditions).assertIsNotNull(jediPower);
    verify(failures).failure(info,elementsShouldNotHave(actual,newArrayList("Yoda"),jediPower));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
