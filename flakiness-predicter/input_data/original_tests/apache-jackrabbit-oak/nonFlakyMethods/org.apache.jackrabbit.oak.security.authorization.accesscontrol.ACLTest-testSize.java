@Test public void testSize() throws RepositoryException {
  AbstractAccessControlList acl=createACL(createTestEntries());
  assertEquals(3,acl.size());
}
