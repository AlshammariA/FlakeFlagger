@Test public void shouldLoadNonEmptyPreProcessors() throws Exception {
  final Map<String,ResourcePreProcessor> map=victim.providePreProcessors();
  assertFalse(map.isEmpty());
}
