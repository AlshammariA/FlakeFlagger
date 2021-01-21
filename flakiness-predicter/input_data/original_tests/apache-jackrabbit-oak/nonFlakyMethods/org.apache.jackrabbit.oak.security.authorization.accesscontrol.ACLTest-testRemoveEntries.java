@Test public void testRemoveEntries() throws Exception {
  JackrabbitAccessControlList acl=createACL(getTestPath(),createTestEntries(),namePathMapper);
  for (  AccessControlEntry ace : acl.getAccessControlEntries()) {
    acl.removeAccessControlEntry(ace);
  }
  assertTrue(acl.isEmpty());
}
