@Test public void shouldUseCorrectDefaultStrategy(){
  assertEquals(SmartWroModelFactory.class,victim.getConfiguredStrategy().getClass());
}
