@Test public void testAuthenticate() throws Exception {
  assertNull("User alread exists in DB",userDAO.findLdapUserByName("allowedUser"));
  Authentication authentication=new UsernamePasswordAuthenticationToken("allowedUser","password");
  Authentication result=authenticationProvider.authenticate(authentication);
  assertTrue(result.isAuthenticated());
  assertNotNull("User was not created",userDAO.findLdapUserByName("allowedUser"));
  result=authenticationProvider.authenticate(authentication);
  assertTrue(result.isAuthenticated());
}
