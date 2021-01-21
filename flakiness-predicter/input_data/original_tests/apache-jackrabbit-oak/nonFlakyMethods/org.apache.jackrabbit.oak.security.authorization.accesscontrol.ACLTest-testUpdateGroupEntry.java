@Test public void testUpdateGroupEntry() throws Exception {
  Privilege[] readPriv=privilegesFromNames(JCR_READ);
  Privilege[] writePriv=privilegesFromNames(JCR_WRITE);
  Principal everyone=principalManager.getEveryone();
  acl.addEntry(testPrincipal,readPriv,true);
  acl.addEntry(everyone,readPriv,true);
  acl.addEntry(testPrincipal,writePriv,false);
  acl.addEntry(everyone,writePriv,true);
  AccessControlEntry[] entries=acl.getAccessControlEntries();
  assertEquals(3,entries.length);
  JackrabbitAccessControlEntry princ2AllowEntry=(JackrabbitAccessControlEntry)entries[1];
  assertEquals(everyone,princ2AllowEntry.getPrincipal());
  assertACE(princ2AllowEntry,true,privilegesFromNames(JCR_READ,JCR_WRITE));
}
