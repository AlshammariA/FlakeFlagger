@Test public void should_pass_if_actual_is_in_range(){
  doubles.assertIsStrictlyBetween(someInfo(),ONE,ZERO,TEN);
}
