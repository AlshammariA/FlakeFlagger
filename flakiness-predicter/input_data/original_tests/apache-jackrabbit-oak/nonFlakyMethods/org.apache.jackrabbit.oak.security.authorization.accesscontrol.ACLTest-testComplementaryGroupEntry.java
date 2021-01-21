@Test public void testComplementaryGroupEntry() throws Exception {
  Privilege[] readPriv=privilegesFromNames(JCR_READ);
  Privilege[] writePriv=privilegesFromNames(JCR_WRITE);
  Principal everyone=principalManager.getEveryone();
  acl.addEntry(testPrincipal,readPriv,true);
  acl.addEntry(everyone,readPriv,true);
  acl.addEntry(testPrincipal,writePriv,false);
  acl.addEntry(everyone,writePriv,true);
  acl.addEntry(testPrincipal,readPriv,false);
  AccessControlEntry[] entries=acl.getAccessControlEntries();
  assertEquals(2,entries.length);
  JackrabbitAccessControlEntry first=(JackrabbitAccessControlEntry)entries[0];
  assertEquals(everyone,first.getPrincipal());
  JackrabbitAccessControlEntry second=(JackrabbitAccessControlEntry)entries[1];
  assertEquals(testPrincipal,second.getPrincipal());
  assertACE(second,false,privilegesFromNames(JCR_READ,JCR_WRITE));
}
