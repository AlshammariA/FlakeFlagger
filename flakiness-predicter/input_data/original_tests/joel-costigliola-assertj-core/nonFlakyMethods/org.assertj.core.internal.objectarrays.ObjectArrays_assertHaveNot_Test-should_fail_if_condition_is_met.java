@Test public void should_fail_if_condition_is_met(){
  testCondition.shouldMatch(false);
  AssertionInfo info=someInfo();
  try {
    actual=array("Solo","Leia","Yoda");
    arrays.assertDoNotHave(someInfo(),actual,jediPower);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,elementsShouldNotHave(actual,newArrayList("Yoda"),jediPower));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
