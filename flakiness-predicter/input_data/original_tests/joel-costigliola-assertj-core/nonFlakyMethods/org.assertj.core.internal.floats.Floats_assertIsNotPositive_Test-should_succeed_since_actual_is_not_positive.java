@Test public void should_succeed_since_actual_is_not_positive(){
  floats.assertIsNotPositive(someInfo(),-6f);
}
