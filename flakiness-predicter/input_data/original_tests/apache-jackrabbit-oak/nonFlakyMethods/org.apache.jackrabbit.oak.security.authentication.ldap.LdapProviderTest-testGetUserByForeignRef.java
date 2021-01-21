@Test public void testGetUserByForeignRef() throws Exception {
  ExternalIdentityRef ref=new ExternalIdentityRef(TEST_USER1_DN,"foobar");
  ExternalIdentity id=idp.getIdentity(ref);
  assertNull("Foreign ref must be null",id);
}
