@Test public void should_pass_if_actual_is_less_than_other(){
  floats.assertLessThanOrEqualTo(someInfo(),6f,8f);
}
