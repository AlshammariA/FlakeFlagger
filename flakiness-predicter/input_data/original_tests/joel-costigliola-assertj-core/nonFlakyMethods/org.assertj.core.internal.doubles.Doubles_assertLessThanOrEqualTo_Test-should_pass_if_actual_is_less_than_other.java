@Test public void should_pass_if_actual_is_less_than_other(){
  doubles.assertLessThanOrEqualTo(someInfo(),6d,8d);
}
