/** 
 * Null login must fail.
 * @throws Exception
 * @see org.apache.jackrabbit.oak.security.authentication.ldap.GuestTokenDefaultLdapLoginModuleTest
 */
@Test public void testNullLogin() throws Exception {
  ContentSession cs=null;
  try {
    cs=login(null);
    fail("Expected null login to fail.");
  }
 catch (  LoginException e) {
  }
 finally {
    if (cs != null) {
      cs.close();
    }
  }
}
