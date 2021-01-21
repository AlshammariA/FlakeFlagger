@Test public void testSize() throws RepositoryException {
  if (acl.addAccessControlEntry(testPrincipal,testPrivileges)) {
    assertTrue(acl.size() > 0);
  }
 else {
    assertEquals(0,acl.size());
  }
}
