@Test public void should_pass_if_big_decimals_are_not_equal(){
  bigDecimals.assertNotEqual(someInfo(),ONE,ONE_WITH_3_DECIMALS);
}
