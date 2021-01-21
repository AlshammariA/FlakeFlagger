@Test public void testExplicitProvider() throws Exception {
  SecureRandom secureRandom=SecureRandom.getInstance(SSL.DEFAULT_SECURE_RANDOM_ALGORITHM);
  factoryBean.setProvider(secureRandom.getProvider().getName());
  assertNotNull(factoryBean.createSecureRandom());
}
