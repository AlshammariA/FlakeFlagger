@Test public void should_pass_if_difference_is_less_than_given_offset(){
  doubles.assertIsCloseTo(someInfo(),ONE,ONE,within(ONE));
  doubles.assertIsCloseTo(someInfo(),ONE,TWO,within(TEN));
}
