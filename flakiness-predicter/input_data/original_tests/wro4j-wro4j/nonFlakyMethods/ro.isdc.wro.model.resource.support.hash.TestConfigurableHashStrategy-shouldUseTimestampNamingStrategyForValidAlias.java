@Test public void shouldUseTimestampNamingStrategyForValidAlias(){
  shouldUseCorrectStrategyForValidAlias(MD5HashStrategy.class,MD5HashStrategy.ALIAS);
}
