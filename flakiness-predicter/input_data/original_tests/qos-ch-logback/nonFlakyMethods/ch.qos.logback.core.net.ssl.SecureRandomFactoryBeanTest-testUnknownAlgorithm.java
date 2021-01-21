@Test public void testUnknownAlgorithm() throws Exception {
  factoryBean.setAlgorithm(SSLTestConstants.FAKE_ALGORITHM_NAME);
  try {
    factoryBean.createSecureRandom();
    fail("expected NoSuchAlgorithmException");
  }
 catch (  NoSuchAlgorithmException ex) {
    assertTrue(ex.getMessage().contains(SSLTestConstants.FAKE_ALGORITHM_NAME));
  }
}
