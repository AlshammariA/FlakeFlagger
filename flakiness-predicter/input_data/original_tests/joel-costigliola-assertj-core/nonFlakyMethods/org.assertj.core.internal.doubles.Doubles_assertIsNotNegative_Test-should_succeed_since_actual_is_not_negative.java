@Test public void should_succeed_since_actual_is_not_negative(){
  doubles.assertIsNotNegative(someInfo(),6d);
}
