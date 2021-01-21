@Test public void testExplicitProvider() throws Exception {
  factoryBean.setLocation(SSLTestConstants.KEYSTORE_JKS_RESOURCE);
  KeyStore keyStore=factoryBean.createKeyStore();
  factoryBean.setProvider(keyStore.getProvider().getName());
  assertNotNull(factoryBean.createKeyStore());
}
