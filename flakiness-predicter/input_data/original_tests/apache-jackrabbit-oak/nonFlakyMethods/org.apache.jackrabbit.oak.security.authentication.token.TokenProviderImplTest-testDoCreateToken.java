@Test public void testDoCreateToken() throws Exception {
  assertFalse(tokenProvider.doCreateToken(new GuestCredentials()));
  assertFalse(tokenProvider.doCreateToken(new TokenCredentials("token")));
  assertFalse(tokenProvider.doCreateToken(getAdminCredentials()));
  SimpleCredentials sc=new SimpleCredentials("uid","pw".toCharArray());
  assertFalse(tokenProvider.doCreateToken(sc));
  sc.setAttribute("any_attribute","value");
  assertFalse(tokenProvider.doCreateToken(sc));
  sc.setAttribute("rep:token_key","value");
  assertFalse(tokenProvider.doCreateToken(sc));
  sc.setAttribute(".token","existing");
  assertFalse(tokenProvider.doCreateToken(sc));
  sc.setAttribute(".token","");
  assertTrue(tokenProvider.doCreateToken(sc));
}
