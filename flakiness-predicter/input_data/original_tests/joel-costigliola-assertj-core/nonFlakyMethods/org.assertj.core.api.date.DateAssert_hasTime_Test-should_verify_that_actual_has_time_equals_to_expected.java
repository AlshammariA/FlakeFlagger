@Test public void should_verify_that_actual_has_time_equals_to_expected(){
  assertions.hasTime(42L);
  verify(dates).assertHasTime(getInfo(assertions),getActual(assertions),42L);
}
