@Test public void should_fail_if_condition_is_met_much(){
  testCondition.shouldMatch(false);
  AssertionInfo info=someInfo();
  try {
    actual=newArrayList("Yoda","Luke","Obiwan");
    iterables.assertAreExactly(someInfo(),actual,2,jedi);
  }
 catch (  AssertionError e) {
    verify(conditions).assertIsNotNull(jedi);
    verify(failures).failure(info,elementsShouldBeExactly(actual,2,jedi));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
