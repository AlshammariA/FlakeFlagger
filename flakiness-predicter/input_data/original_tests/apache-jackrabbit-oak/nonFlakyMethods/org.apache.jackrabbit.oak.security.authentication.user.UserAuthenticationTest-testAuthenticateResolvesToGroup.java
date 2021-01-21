@Test public void testAuthenticateResolvesToGroup() throws Exception {
  Group g=getUserManager(root).createGroup("g1");
  SimpleCredentials sc=new SimpleCredentials(g.getID(),"pw".toCharArray());
  Authentication a=new UserAuthentication(sc.getUserID(),getUserManager(root));
  try {
    a.authenticate(sc);
    fail("Authenticating Group should fail");
  }
 catch (  LoginException e) {
  }
 finally {
    if (g != null) {
      g.remove();
      root.commit();
    }
  }
}
