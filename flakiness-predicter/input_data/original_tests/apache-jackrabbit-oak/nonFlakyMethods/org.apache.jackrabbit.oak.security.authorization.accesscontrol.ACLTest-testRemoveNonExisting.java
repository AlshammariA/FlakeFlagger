@Test public void testRemoveNonExisting() throws Exception {
  try {
    acl.removeAccessControlEntry(createEntry(testPrincipal,testPrivileges,true));
    fail("Removing a non-existing ACE should fail.");
  }
 catch (  AccessControlException e) {
  }
}
