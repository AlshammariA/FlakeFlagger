@Test public void should_pass_if_Condition_is_not_met(){
  condition.shouldMatch(false);
  conditions.assertIsNot(someInfo(),actual,condition);
}
