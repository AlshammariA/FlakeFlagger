@Test public void testExplicitAlgorithm() throws Exception {
  factoryBean.setAlgorithm(KeyManagerFactory.getDefaultAlgorithm());
  assertNotNull(factoryBean.createKeyManagerFactory());
}
