@Test public void testSplitDNIntermediatePath() throws Exception {
  providerConfig.getUserConfig().setMakeDnPath(true);
  ExternalUser user=idp.getUser(TEST_USER1_UID);
  assertNotNull("User 1 must exist",user);
  assertEquals("Intermediate path must be the split dn",TEST_USER1_PATH,user.getIntermediatePath());
}
