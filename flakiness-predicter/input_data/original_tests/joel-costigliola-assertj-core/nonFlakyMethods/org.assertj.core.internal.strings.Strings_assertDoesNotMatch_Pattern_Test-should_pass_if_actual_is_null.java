@Test public void should_pass_if_actual_is_null(){
  strings.assertDoesNotMatch(someInfo(),null,matchAnything());
}
