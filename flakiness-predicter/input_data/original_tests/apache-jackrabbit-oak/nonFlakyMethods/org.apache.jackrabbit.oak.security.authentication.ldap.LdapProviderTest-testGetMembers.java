@Test public void testGetMembers() throws Exception {
  ExternalIdentityRef ref=new ExternalIdentityRef(TEST_GROUP1_DN,IDP_NAME);
  ExternalIdentity id=idp.getIdentity(ref);
  assertTrue("Group instance",id instanceof ExternalGroup);
  ExternalGroup grp=(ExternalGroup)id;
  assertIfEquals("Group members",TEST_GROUP1_MEMBERS,grp.getDeclaredMembers());
}
