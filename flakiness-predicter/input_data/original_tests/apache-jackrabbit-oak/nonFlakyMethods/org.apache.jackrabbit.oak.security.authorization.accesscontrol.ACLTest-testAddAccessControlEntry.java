@Test public void testAddAccessControlEntry() throws Exception {
  assertTrue(acl.addAccessControlEntry(testPrincipal,testPrivileges));
  assertFalse(acl.isEmpty());
}
