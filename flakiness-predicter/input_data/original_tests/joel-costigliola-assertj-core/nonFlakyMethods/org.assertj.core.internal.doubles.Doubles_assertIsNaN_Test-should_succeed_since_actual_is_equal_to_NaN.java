@Test public void should_succeed_since_actual_is_equal_to_NaN(){
  doubles.assertIsNaN(someInfo(),Double.NaN);
}
