@Test public void should_pass_if_difference_is_less_than_given_offset(){
  floats.assertIsCloseTo(someInfo(),ONE,ONE,within(ONE));
  floats.assertIsCloseTo(someInfo(),ONE,TWO,within(TEN));
}
