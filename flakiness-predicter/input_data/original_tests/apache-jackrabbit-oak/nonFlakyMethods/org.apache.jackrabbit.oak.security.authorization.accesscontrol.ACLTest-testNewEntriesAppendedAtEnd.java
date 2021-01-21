@Test public void testNewEntriesAppendedAtEnd() throws Exception {
  Privilege[] readPriv=privilegesFromNames(JCR_READ);
  Privilege[] writePriv=privilegesFromNames(JCR_WRITE);
  acl.addEntry(testPrincipal,readPriv,true);
  acl.addEntry(principalManager.getEveryone(),readPriv,true);
  acl.addEntry(testPrincipal,writePriv,false);
  AccessControlEntry[] entries=acl.getAccessControlEntries();
  assertEquals(3,entries.length);
  JackrabbitAccessControlEntry last=(JackrabbitAccessControlEntry)entries[2];
  assertEquals(testPrincipal,last.getPrincipal());
  assertACE(last,false,writePriv);
}
