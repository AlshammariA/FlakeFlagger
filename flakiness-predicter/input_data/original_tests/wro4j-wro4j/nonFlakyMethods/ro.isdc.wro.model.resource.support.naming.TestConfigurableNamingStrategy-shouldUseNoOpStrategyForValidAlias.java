@Test public void shouldUseNoOpStrategyForValidAlias(){
  shouldUseCorrectStrategyForValidAlias(NoOpNamingStrategy.class,NoOpNamingStrategy.ALIAS);
}
