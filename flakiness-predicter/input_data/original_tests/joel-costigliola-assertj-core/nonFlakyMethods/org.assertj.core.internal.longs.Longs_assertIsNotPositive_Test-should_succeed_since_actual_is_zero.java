@Test public void should_succeed_since_actual_is_zero(){
  longs.assertIsNotPositive(someInfo(),0L);
}
