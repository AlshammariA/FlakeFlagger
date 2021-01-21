@Test public void should_fail_if_Condition_is_not_met(){
  condition.shouldMatch(false);
  AssertionInfo info=someInfo();
  try {
    conditions.assertHas(info,actual,condition);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldHave(actual,condition));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
