@Test public void should_succeed_since_actual_is_zero(){
  shorts.assertIsNotNegative(someInfo(),(short)0);
}
