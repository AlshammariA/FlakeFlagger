@Test public void should_fail_if_actual_does_not_satisfy_condition_at_index(){
  condition.shouldMatch(false);
  AssertionInfo info=someInfo();
  Index index=atIndex(1);
  try {
    lists.assertHas(info,actual,condition,index);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldHaveAtIndex(actual,condition,index,"Luke"));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
