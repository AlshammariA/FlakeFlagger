@Test public void testRemoveEntry() throws Exception {
  assertTrue(acl.addAccessControlEntry(testPrincipal,testPrivileges));
  acl.removeAccessControlEntry(acl.getAccessControlEntries()[0]);
  assertTrue(acl.isEmpty());
}
