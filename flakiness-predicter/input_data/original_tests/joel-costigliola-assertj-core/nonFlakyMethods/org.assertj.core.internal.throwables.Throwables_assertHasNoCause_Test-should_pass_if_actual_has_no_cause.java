@Test public void should_pass_if_actual_has_no_cause(){
  throwables.assertHasNoCause(someInfo(),actual);
}
