@Test public void should_succeed_since_actual_is_not_negative(){
  longs.assertIsNotNegative(someInfo(),6L);
}
