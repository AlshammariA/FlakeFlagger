@Test public void should_pass_if_actual_does_not_match_regular_expression(){
  strings.assertDoesNotMatch(someInfo(),actual,"Luke");
}
