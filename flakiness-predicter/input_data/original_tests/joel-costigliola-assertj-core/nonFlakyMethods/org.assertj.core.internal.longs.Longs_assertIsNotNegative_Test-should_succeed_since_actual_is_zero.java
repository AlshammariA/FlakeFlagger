@Test public void should_succeed_since_actual_is_zero(){
  longs.assertIsNotNegative(someInfo(),0L);
}
