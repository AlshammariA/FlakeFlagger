@Test public void should_fail_if_Condition_is_not_met(){
  testCondition.shouldMatch(false);
  AssertionInfo info=someInfo();
  try {
    actual=array("Yoda","Luke","Leia");
    arrays.assertHave(someInfo(),actual,jediPower);
  }
 catch (  AssertionError e) {
    verify(conditions).assertIsNotNull(jediPower);
    verify(failures).failure(info,elementsShouldHave(actual,newArrayList("Leia"),jediPower));
    verify(failures).failure(info,elementsShouldHave(actual,newArrayList("Leia"),jediPower));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
