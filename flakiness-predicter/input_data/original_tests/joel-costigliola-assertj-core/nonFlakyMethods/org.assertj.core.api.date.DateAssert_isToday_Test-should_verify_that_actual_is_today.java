@Test public void should_verify_that_actual_is_today(){
  assertions.isToday();
  verify(dates).assertIsToday(getInfo(assertions),getActual(assertions));
}
