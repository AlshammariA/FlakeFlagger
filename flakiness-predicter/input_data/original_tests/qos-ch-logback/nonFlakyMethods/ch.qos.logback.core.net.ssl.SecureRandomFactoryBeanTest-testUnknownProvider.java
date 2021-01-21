@Test public void testUnknownProvider() throws Exception {
  factoryBean.setProvider(SSLTestConstants.FAKE_PROVIDER_NAME);
  try {
    factoryBean.createSecureRandom();
    fail("expected NoSuchProviderException");
  }
 catch (  NoSuchProviderException ex) {
    assertTrue(ex.getMessage().contains(SSLTestConstants.FAKE_PROVIDER_NAME));
  }
}
