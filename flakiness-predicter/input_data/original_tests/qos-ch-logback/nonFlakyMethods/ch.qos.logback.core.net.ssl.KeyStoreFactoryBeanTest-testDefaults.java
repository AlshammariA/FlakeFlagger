@Test public void testDefaults() throws Exception {
  factoryBean.setLocation(SSLTestConstants.KEYSTORE_JKS_RESOURCE);
  assertNotNull(factoryBean.createKeyStore());
}
