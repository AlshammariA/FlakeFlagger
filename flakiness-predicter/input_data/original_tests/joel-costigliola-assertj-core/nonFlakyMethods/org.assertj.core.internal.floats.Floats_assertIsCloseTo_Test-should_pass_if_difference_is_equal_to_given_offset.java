@Test public void should_pass_if_difference_is_equal_to_given_offset(){
  floats.assertIsCloseTo(someInfo(),ONE,ONE,within(ZERO));
  floats.assertIsCloseTo(someInfo(),ONE,ZERO,within(ONE));
  floats.assertIsCloseTo(someInfo(),ONE,TWO,within(ONE));
}
