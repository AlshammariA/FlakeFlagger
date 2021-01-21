@Test public void testExplicitProvider() throws Exception {
  TrustManagerFactory factory=TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
  factoryBean.setProvider(factory.getProvider().getName());
  assertNotNull(factoryBean.createTrustManagerFactory());
}
