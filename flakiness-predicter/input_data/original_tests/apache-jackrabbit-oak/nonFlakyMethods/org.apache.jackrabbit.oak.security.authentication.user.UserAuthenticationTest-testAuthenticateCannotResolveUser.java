@Test public void testAuthenticateCannotResolveUser() throws Exception {
  SimpleCredentials sc=new SimpleCredentials("unknownUser","pw".toCharArray());
  Authentication a=new UserAuthentication(sc.getUserID(),getUserManager(root));
  assertFalse(a.authenticate(sc));
}
