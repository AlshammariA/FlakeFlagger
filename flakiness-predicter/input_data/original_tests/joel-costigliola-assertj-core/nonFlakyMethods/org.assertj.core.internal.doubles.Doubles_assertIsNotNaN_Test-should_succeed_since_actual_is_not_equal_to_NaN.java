@Test public void should_succeed_since_actual_is_not_equal_to_NaN(){
  doubles.assertIsNotNaN(someInfo(),6d);
}
