@Test public void shouldUseNoOpNamingStrategyByDefault(){
  Assert.assertSame(NoOpNamingStrategy.class,victim.getConfiguredStrategy().getClass());
}
