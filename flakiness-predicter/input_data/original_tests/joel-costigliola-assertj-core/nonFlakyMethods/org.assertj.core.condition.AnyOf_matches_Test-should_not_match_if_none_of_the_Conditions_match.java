@Test public void should_not_match_if_none_of_the_Conditions_match(){
  condition1.shouldMatch(false);
  condition2.shouldMatch(false);
  assertFalse(anyOf.matches("Yoda"));
}
