@Test public void should_succeed_since_actual_is_negative(){
  shorts.assertIsNegative(someInfo(),(short)-6);
}
