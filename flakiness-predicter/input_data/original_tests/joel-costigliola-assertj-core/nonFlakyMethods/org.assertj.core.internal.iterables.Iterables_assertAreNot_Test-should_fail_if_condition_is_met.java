@Test public void should_fail_if_condition_is_met(){
  testCondition.shouldMatch(false);
  AssertionInfo info=someInfo();
  try {
    actual=newArrayList("Solo","Leia","Yoda");
    iterables.assertAreNot(someInfo(),actual,jedi);
  }
 catch (  AssertionError e) {
    verify(conditions).assertIsNotNull(jedi);
    verify(failures).failure(info,elementsShouldNotBe(actual,newArrayList("Yoda"),jedi));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
