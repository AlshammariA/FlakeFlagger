@Test public void should_match_if_all_Condition_match(){
  condition1.shouldMatch(true);
  condition2.shouldMatch(true);
  assertTrue(allOf.matches("Yoda"));
}
