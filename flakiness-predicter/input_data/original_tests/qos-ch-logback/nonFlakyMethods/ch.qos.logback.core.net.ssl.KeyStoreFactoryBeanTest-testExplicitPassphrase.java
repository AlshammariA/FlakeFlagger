@Test public void testExplicitPassphrase() throws Exception {
  factoryBean.setLocation(SSLTestConstants.KEYSTORE_JKS_RESOURCE);
  factoryBean.setPassword(SSL.DEFAULT_KEYSTORE_PASSWORD);
  assertNotNull(factoryBean.createKeyStore());
}
