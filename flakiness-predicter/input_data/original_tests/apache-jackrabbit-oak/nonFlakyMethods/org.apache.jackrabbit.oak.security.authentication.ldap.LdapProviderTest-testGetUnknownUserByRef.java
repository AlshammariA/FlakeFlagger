@Test public void testGetUnknownUserByRef() throws Exception {
  ExternalIdentityRef ref=new ExternalIdentityRef("bla=foo," + TEST_USER1_DN,IDP_NAME);
  ExternalIdentity id=idp.getIdentity(ref);
  assertNull("Unknown user must return null",id);
}
