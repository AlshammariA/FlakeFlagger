@Test public void should_not_match_if_at_least_one_Condition_does_not_match(){
  condition1.shouldMatch(true);
  condition2.shouldMatch(false);
  assertFalse(allOf.matches("Yoda"));
}
