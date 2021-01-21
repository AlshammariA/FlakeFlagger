@Test public void testNullPrivileges() throws Exception {
  try {
    ACE empty=new EmptyACE(null);
    fail("Privileges must not be null");
  }
 catch (  AccessControlException e) {
  }
}
