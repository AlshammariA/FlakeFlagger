@Test public void testPKCS12Type() throws Exception {
  factoryBean.setLocation(SSLTestConstants.KEYSTORE_PKCS12_RESOURCE);
  factoryBean.setType(SSLTestConstants.PKCS12_TYPE);
  assertNotNull(factoryBean.createKeyStore());
}
