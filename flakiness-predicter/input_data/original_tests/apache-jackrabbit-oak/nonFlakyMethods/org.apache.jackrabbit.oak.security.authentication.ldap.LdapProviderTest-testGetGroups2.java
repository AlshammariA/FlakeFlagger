@Test public void testGetGroups2() throws Exception {
  ExternalIdentityRef ref=new ExternalIdentityRef(TEST_USER0_DN,IDP_NAME);
  ExternalIdentity id=idp.getIdentity(ref);
  assertTrue("User instance",id instanceof ExternalUser);
  assertIfEquals("Groups",TEST_USER0_GROUPS,id.getDeclaredGroups());
}
