@Test public void should_pass_if_actual_is_in_range(){
  floats.assertIsBetween(someInfo(),ONE,ZERO,TEN);
}
