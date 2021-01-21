@Test public void testGetGroupByRef() throws Exception {
  ExternalIdentityRef ref=new ExternalIdentityRef(TEST_GROUP1_DN,IDP_NAME);
  ExternalIdentity id=idp.getIdentity(ref);
  assertTrue("Group instance",id instanceof ExternalGroup);
  assertEquals("Group Name",TEST_GROUP1_NAME,id.getId());
}
