@Test public void should_pass_if_actual_is_greater_than_other(){
  doubles.assertGreaterThan(someInfo(),8d,6d);
}
