@Test public void should_fail_if_Condition_is_met(){
  condition.shouldMatch(true);
  AssertionInfo info=someInfo();
  try {
    conditions.assertDoesNotHave(info,actual,condition);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotHave(actual,condition));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
