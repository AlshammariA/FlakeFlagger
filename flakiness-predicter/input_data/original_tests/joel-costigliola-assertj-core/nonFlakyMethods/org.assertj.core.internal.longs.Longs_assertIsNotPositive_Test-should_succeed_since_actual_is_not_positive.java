@Test public void should_succeed_since_actual_is_not_positive(){
  longs.assertIsNotPositive(someInfo(),-6L);
}
