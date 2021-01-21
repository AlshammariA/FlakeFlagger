@Test public void testExplicitType() throws Exception {
  factoryBean.setLocation(SSLTestConstants.KEYSTORE_JKS_RESOURCE);
  factoryBean.setType(SSL.DEFAULT_KEYSTORE_TYPE);
  assertNotNull(factoryBean.createKeyStore());
}
