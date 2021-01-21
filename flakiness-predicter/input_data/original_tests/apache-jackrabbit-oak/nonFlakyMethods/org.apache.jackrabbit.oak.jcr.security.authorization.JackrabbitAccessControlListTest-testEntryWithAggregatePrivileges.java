/** 
 * @see <a href="https://issues.apache.org/jira/browse/OAK-1026">OAK-1026</a>
 */
@Test public void testEntryWithAggregatePrivileges() throws Exception {
  Privilege write=acMgr.privilegeFromName(Privilege.JCR_WRITE);
  acl.addEntry(testPrincipal,write.getAggregatePrivileges(),true);
  AccessControlEntry[] entries=acl.getAccessControlEntries();
  assertEquals(1,entries.length);
  assertArrayEquals(new Privilege[]{write},entries[0].getPrivileges());
  acMgr.setPolicy(acl.getPath(),acl);
  AccessControlPolicy policy=AccessControlUtils.getAccessControlList(acMgr,acl.getPath());
  assertNotNull(policy);
  entries=acl.getAccessControlEntries();
  assertEquals(1,entries.length);
  assertArrayEquals(new Privilege[]{write},entries[0].getPrivileges());
}
