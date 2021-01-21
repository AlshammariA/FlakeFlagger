@Test public void testReorderToTheEnd() throws Exception {
  Privilege[] read=privilegesFromNames(JCR_READ,JCR_READ_ACCESS_CONTROL);
  Privilege[] write=privilegesFromNames(JCR_WRITE);
  AbstractAccessControlList acl=createEmptyACL();
  acl.addAccessControlEntry(testPrincipal,read);
  acl.addEntry(testPrincipal,write,false);
  acl.addAccessControlEntry(EveryonePrincipal.getInstance(),write);
  List<? extends JackrabbitAccessControlEntry> entries=acl.getEntries();
  assertEquals(3,entries.size());
  AccessControlEntry first=entries.get(0);
  acl.orderBefore(first,null);
  List<? extends JackrabbitAccessControlEntry> entriesAfter=acl.getEntries();
  assertEquals(first,entriesAfter.get(2));
}
