@Test public void shouldUseCRC32StrategyForValidAlias(){
  shouldUseCorrectStrategyForValidAlias(CRC32HashStrategy.class,CRC32HashStrategy.ALIAS);
}
