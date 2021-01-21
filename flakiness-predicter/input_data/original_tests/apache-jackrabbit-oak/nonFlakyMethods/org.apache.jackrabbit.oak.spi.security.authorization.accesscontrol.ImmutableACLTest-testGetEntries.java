@Test public void testGetEntries() throws RepositoryException {
  List<ACE> aces=createTestEntries();
  AbstractAccessControlList acl=createACL(aces);
  assertNotNull(acl.getEntries());
  assertNotNull(acl.getAccessControlEntries());
  assertEquals(aces.size(),acl.getEntries().size());
  assertEquals(aces.size(),acl.getAccessControlEntries().length);
  assertTrue(acl.getEntries().containsAll(aces));
  assertTrue(Arrays.asList(acl.getAccessControlEntries()).containsAll(aces));
}
