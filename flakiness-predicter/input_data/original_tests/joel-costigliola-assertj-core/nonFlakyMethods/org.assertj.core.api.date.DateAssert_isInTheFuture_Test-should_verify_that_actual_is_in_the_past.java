@Test public void should_verify_that_actual_is_in_the_past(){
  assertions.isInTheFuture();
  verify(dates).assertIsInTheFuture(getInfo(assertions),getActual(assertions));
}
