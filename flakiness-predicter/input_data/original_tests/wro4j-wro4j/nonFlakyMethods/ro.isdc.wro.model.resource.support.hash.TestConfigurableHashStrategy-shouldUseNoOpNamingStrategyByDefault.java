@Test public void shouldUseNoOpNamingStrategyByDefault(){
  Assert.assertSame(SHA1HashStrategy.class,victim.getConfiguredStrategy().getClass());
}
