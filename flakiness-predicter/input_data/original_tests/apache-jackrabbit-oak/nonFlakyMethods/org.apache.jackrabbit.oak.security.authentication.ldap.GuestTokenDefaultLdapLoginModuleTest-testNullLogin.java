/** 
 * Null login must succeed and result in an guest session as the OPTIONAL {@link GuestLoginModule} adds {@link javax.jcr.GuestCredentials} to theshared state.
 * @throws Exception
 */
@Test public void testNullLogin() throws Exception {
  ContentSession cs=login(null);
  assertEquals(UserConstants.DEFAULT_ANONYMOUS_ID,cs.getAuthInfo().getUserID());
  cs.close();
}
