@Test public void should_succeed_since_actual_is_not_equal_to_NaN(){
  floats.assertIsNotNaN(someInfo(),6f);
}
