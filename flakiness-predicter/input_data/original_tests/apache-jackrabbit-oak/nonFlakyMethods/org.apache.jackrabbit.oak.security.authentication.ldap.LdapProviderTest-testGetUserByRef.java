@Test public void testGetUserByRef() throws Exception {
  ExternalIdentityRef ref=new ExternalIdentityRef(TEST_USER1_DN,IDP_NAME);
  ExternalIdentity id=idp.getIdentity(ref);
  assertTrue("User instance",id instanceof ExternalUser);
  assertEquals("User ID",TEST_USER1_UID,id.getId());
}
