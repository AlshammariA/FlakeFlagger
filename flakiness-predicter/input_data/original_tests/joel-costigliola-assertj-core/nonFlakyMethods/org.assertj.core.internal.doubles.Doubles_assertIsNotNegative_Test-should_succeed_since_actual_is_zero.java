@Test public void should_succeed_since_actual_is_zero(){
  doubles.assertIsNotNegative(someInfo(),0d);
}
