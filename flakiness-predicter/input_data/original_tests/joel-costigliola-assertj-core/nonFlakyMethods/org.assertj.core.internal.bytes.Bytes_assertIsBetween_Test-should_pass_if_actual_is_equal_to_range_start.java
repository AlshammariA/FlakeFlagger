@Test public void should_pass_if_actual_is_equal_to_range_start(){
  bytes.assertIsBetween(someInfo(),ONE,ONE,TEN);
}
