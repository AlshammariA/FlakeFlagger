@Test public void should_succeed_since_actual_is_not_positive(){
  shorts.assertIsNotPositive(someInfo(),(short)-6);
}
