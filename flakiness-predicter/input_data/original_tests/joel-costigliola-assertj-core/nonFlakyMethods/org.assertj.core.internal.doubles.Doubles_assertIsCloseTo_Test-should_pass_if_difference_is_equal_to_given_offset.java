@Test public void should_pass_if_difference_is_equal_to_given_offset(){
  doubles.assertIsCloseTo(someInfo(),ONE,ONE,within(ZERO));
  doubles.assertIsCloseTo(someInfo(),ONE,ZERO,within(ONE));
  doubles.assertIsCloseTo(someInfo(),ONE,TWO,within(ONE));
}
