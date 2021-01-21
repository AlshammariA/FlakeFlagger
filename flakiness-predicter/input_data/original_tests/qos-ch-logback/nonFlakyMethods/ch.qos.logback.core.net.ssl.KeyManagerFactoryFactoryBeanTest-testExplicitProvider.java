@Test public void testExplicitProvider() throws Exception {
  KeyManagerFactory factory=KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
  factoryBean.setProvider(factory.getProvider().getName());
  assertNotNull(factoryBean.createKeyManagerFactory());
}
