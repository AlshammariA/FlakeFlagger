@Test public void shouldUseHashEncoderStrategyForValidAlias(){
  shouldUseCorrectStrategyForValidAlias(SHA1HashStrategy.class,SHA1HashStrategy.ALIAS);
}
