@Test public void should_succeed_since_actual_is_not_positive(){
  doubles.assertIsNotPositive(someInfo(),-6d);
}
