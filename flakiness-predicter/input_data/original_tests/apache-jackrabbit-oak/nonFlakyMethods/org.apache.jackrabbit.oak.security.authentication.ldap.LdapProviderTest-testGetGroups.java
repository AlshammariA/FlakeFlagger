@Test public void testGetGroups() throws Exception {
  ExternalIdentityRef ref=new ExternalIdentityRef(TEST_USER1_DN,IDP_NAME);
  ExternalIdentity id=idp.getIdentity(ref);
  assertTrue("User instance",id instanceof ExternalUser);
  assertIfEquals("Groups",TEST_USER1_GROUPS,id.getDeclaredGroups());
}
