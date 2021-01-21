@Test public void testGetUserByUserId() throws Exception {
  ExternalUser user=idp.getUser(TEST_USER1_UID);
  assertNotNull("User 1 must exist",user);
  assertEquals("User Ref",TEST_USER1_DN,user.getExternalId().getId());
}
