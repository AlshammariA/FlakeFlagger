@Test public void should_verify_that_actual_is_in_the_past(){
  assertions.isInThePast();
  verify(dates).assertIsInThePast(getInfo(assertions),getActual(assertions));
}
