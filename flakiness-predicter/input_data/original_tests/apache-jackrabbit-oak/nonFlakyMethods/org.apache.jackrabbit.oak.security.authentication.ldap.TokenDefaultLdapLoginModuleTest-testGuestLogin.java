/** 
 * Login with  {@link javax.jcr.GuestCredentials} must succeed and result inan guest session as the SUFFICIENT {@link org.apache.jackrabbit.oak.spi.security.authentication.LoginModuleImpl}handles the guest login (in contrast to the ExternalLoginModule).
 * @throws Exception
 */
@Test public void testGuestLogin() throws Exception {
  ContentSession cs=login(new GuestCredentials());
  assertEquals(UserConstants.DEFAULT_ANONYMOUS_ID,cs.getAuthInfo().getUserID());
  cs.close();
}
