@Test public void shouldProvideGoogleClosureWhitespace() throws Exception {
  assertTrue(victim.providePreProcessors().keySet().contains(GoogleClosureCompressorProcessor.ALIAS_WHITESPACE_ONLY));
}
