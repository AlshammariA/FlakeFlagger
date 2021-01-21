@Test public void testEmptyPrivileges() throws Exception {
  try {
    ACE empty=new EmptyACE(PrivilegeBits.EMPTY);
    fail("Privileges must not be empty.");
  }
 catch (  AccessControlException e) {
  }
}
