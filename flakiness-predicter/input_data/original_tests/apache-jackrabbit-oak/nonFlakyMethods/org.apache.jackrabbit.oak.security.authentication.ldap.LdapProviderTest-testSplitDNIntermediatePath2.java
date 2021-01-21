@Test public void testSplitDNIntermediatePath2() throws Exception {
  providerConfig.getUserConfig().setMakeDnPath(true);
  ExternalUser user=idp.getUser(TEST_USER5_UID);
  assertNotNull("User 5 must exist",user);
  assertEquals("Intermediate path must be the split dn",TEST_USER5_PATH,user.getIntermediatePath());
}
