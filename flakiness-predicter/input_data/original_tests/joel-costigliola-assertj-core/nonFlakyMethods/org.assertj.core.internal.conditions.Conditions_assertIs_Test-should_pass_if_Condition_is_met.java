@Test public void should_pass_if_Condition_is_met(){
  condition.shouldMatch(true);
  conditions.assertIs(someInfo(),actual,condition);
}
