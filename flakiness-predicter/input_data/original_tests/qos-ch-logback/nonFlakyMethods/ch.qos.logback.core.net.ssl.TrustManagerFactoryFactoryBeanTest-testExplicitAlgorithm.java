@Test public void testExplicitAlgorithm() throws Exception {
  factoryBean.setAlgorithm(TrustManagerFactory.getDefaultAlgorithm());
  assertNotNull(factoryBean.createTrustManagerFactory());
}
