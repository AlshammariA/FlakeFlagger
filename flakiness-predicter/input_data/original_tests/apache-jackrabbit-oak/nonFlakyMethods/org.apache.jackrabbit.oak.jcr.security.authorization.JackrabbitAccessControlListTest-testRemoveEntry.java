@Test public void testRemoveEntry() throws NotExecutableException, RepositoryException {
  Principal princ=getValidPrincipal();
  Privilege[] grPriv=privilegesFromName("rep:write");
  acl.addEntry(princ,grPriv,true,Collections.<String,Value>emptyMap());
  AccessControlEntry[] entries=acl.getAccessControlEntries();
  int length=entries.length;
  assertTrue("Grant was both successful -> at least 1 entry.",length > 0);
  for (  AccessControlEntry entry : entries) {
    acl.removeAccessControlEntry(entry);
    length=length - 1;
    assertEquals(length,acl.size());
    assertEquals(length,acl.getAccessControlEntries().length);
  }
  assertTrue(acl.isEmpty());
  assertEquals(0,acl.size());
  assertEquals(0,acl.getAccessControlEntries().length);
}
