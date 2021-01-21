@Test public void testReorder() throws Exception {
  Privilege[] read=privilegesFromNames(JCR_READ,JCR_READ_ACCESS_CONTROL);
  Privilege[] write=privilegesFromNames(JCR_WRITE);
  AbstractAccessControlList acl=createEmptyACL();
  acl.addAccessControlEntry(testPrincipal,read);
  acl.addEntry(testPrincipal,write,false);
  acl.addAccessControlEntry(EveryonePrincipal.getInstance(),write);
  AccessControlEntry[] entries=acl.getAccessControlEntries();
  assertEquals(3,entries.length);
  AccessControlEntry first=entries[0];
  AccessControlEntry second=entries[1];
  AccessControlEntry third=entries[2];
  acl.orderBefore(second,first);
  assertEquals(second,acl.getEntries().get(0));
  assertEquals(first,acl.getEntries().get(1));
  assertEquals(third,acl.getEntries().get(2));
  acl.orderBefore(third,first);
  assertEquals(second,acl.getEntries().get(0));
  assertEquals(third,acl.getEntries().get(1));
  assertEquals(first,acl.getEntries().get(2));
}
