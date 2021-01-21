@Test public void testAddEntryWithInvalidPrivilege() throws Exception {
  try {
    acl.addAccessControlEntry(testPrincipal,new Privilege[]{new InvalidPrivilege()});
    fail("Adding an ACE with invalid privileges should fail.");
  }
 catch (  AccessControlException e) {
  }
}
