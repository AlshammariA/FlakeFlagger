@Test public void testIsEmpty() throws RepositoryException {
  AbstractAccessControlList acl=createACL(createTestEntries());
  assertFalse(acl.isEmpty());
}
