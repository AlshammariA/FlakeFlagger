@Test public void testNullIntermediatePath() throws Exception {
  providerConfig.getUserConfig().setMakeDnPath(false);
  ExternalUser user=idp.getUser(TEST_USER1_UID);
  assertNotNull("User 1 must exist",user);
  assertNull("Intermediate path must be null",user.getIntermediatePath());
}
