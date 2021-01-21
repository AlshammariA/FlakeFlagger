public void testImportACLOnly() throws Exception {
  try {
    Node target=createImportTarget();
    doImport(target.getPath(),XML_POLICY_TREE_3);
    String path=target.getPath();
    AccessControlManager acMgr=superuser.getAccessControlManager();
    AccessControlPolicy[] policies=acMgr.getPolicies(path);
    assertEquals(1,policies.length);
    assertTrue(policies[0] instanceof JackrabbitAccessControlList);
    AccessControlEntry[] entries=((JackrabbitAccessControlList)policies[0]).getAccessControlEntries();
    assertEquals(2,entries.length);
    AccessControlEntry entry=entries[0];
    assertEquals("everyone",entry.getPrincipal().getName());
    assertEquals(1,entry.getPrivileges().length);
    assertEquals(acMgr.privilegeFromName(Privilege.JCR_WRITE),entry.getPrivileges()[0]);
    entry=entries[1];
    assertEquals("admin",entry.getPrincipal().getName());
    assertEquals(1,entry.getPrivileges().length);
    assertEquals(acMgr.privilegeFromName(Privilege.JCR_WRITE),entry.getPrivileges()[0]);
    if (entry instanceof JackrabbitAccessControlEntry) {
      assertTrue(((JackrabbitAccessControlEntry)entry).isAllow());
    }
  }
  finally {
    superuser.refresh(false);
  }
}
