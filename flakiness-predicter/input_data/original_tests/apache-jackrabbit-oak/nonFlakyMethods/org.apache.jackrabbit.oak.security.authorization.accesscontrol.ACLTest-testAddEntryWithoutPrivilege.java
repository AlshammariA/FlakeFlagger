@Test public void testAddEntryWithoutPrivilege() throws Exception {
  try {
    acl.addAccessControlEntry(testPrincipal,new Privilege[0]);
    fail("Adding an ACE with empty privilege array should fail.");
  }
 catch (  AccessControlException e) {
  }
  try {
    acl.addAccessControlEntry(testPrincipal,null);
    fail("Adding an ACE with null privileges should fail.");
  }
 catch (  AccessControlException e) {
  }
}
