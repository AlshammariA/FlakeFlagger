@Test public void should_succeed_since_actual_is_not_negative(){
  shorts.assertIsNotNegative(someInfo(),(short)6);
}
