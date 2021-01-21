@Test public void should_fail_if_Condition_is_not_met(){
  testCondition.shouldMatch(false);
  AssertionInfo info=someInfo();
  try {
    actual=array("Yoda","Luke","Leia");
    arrays.assertAre(someInfo(),actual,jedi);
  }
 catch (  AssertionError e) {
    verify(conditions).assertIsNotNull(jedi);
    verify(failures).failure(info,elementsShouldBe(actual,newArrayList("Leia"),jedi));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
