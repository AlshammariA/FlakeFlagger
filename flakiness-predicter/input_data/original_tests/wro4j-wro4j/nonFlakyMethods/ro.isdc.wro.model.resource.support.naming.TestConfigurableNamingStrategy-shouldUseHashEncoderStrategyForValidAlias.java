@Test public void shouldUseHashEncoderStrategyForValidAlias(){
  shouldUseCorrectStrategyForValidAlias(DefaultHashEncoderNamingStrategy.class,DefaultHashEncoderNamingStrategy.ALIAS);
}
