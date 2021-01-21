@Test public void testEmptyAcl() throws RepositoryException {
  AbstractAccessControlList acl=createEmptyACL();
  assertNotNull(acl.getAccessControlEntries());
  assertNotNull(acl.getEntries());
  assertTrue(acl.getAccessControlEntries().length == 0);
  assertEquals(acl.getAccessControlEntries().length,acl.getEntries().size());
  assertEquals(0,acl.size());
  assertTrue(acl.isEmpty());
}
