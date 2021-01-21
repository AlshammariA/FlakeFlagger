@Test public void testImportUnknownPrincipal() throws Exception {
  runImport();
  AccessControlManager acMgr=adminSession.getAccessControlManager();
  AccessControlPolicy[] policies=acMgr.getPolicies(target.getPath());
  assertEquals(1,policies.length);
  assertTrue(policies[0] instanceof JackrabbitAccessControlList);
  AccessControlEntry[] entries=((JackrabbitAccessControlList)policies[0]).getAccessControlEntries();
  assertEquals(1,entries.length);
  AccessControlEntry entry=entries[0];
  assertEquals("unknownprincipal",entry.getPrincipal().getName());
  assertEquals(1,entry.getPrivileges().length);
  assertEquals(acMgr.privilegeFromName(Privilege.JCR_WRITE),entry.getPrivileges()[0]);
  if (entry instanceof JackrabbitAccessControlEntry) {
    assertTrue(((JackrabbitAccessControlEntry)entry).isAllow());
  }
}
