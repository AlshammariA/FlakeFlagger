@Test public void testIsEmpty() throws RepositoryException {
  if (acl.addAccessControlEntry(testPrincipal,testPrivileges)) {
    assertFalse(acl.isEmpty());
  }
 else {
    assertTrue(acl.isEmpty());
  }
}
