@Test public void should_pass_if_actual_does_not_match_Pattern(){
  strings.assertDoesNotMatch(someInfo(),actual,Pattern.compile("Luke"));
}
