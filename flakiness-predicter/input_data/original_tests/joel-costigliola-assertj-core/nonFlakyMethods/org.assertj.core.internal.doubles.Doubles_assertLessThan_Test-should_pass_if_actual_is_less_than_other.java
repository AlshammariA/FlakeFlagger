@Test public void should_pass_if_actual_is_less_than_other(){
  doubles.assertLessThan(someInfo(),6d,8d);
}
