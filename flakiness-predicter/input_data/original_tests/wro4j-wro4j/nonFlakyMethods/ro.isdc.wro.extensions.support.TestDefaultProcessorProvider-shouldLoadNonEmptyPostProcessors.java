@Test public void shouldLoadNonEmptyPostProcessors() throws Exception {
  final Map<String,ResourcePostProcessor> map=victim.providePostProcessors();
  assertFalse(map.isEmpty());
}
