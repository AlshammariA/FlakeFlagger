@Test public void should_match_if_at_least_one_Condition_matches(){
  condition1.shouldMatch(false);
  condition2.shouldMatch(true);
  assertTrue(anyOf.matches("Yoda"));
}
