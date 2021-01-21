/** 
 * Imports a resource-based ACL containing a single entry.
 * @throws Exception
 */
public void testImportACL() throws Exception {
  try {
    Node target=testRootNode;
    doImport(target.getPath(),XML_POLICY_TREE);
    assertTrue(target.hasNode("test"));
    String path=target.getNode("test").getPath();
    AccessControlManager acMgr=superuser.getAccessControlManager();
    AccessControlPolicy[] policies=acMgr.getPolicies(path);
    assertEquals(1,policies.length);
    assertTrue(policies[0] instanceof JackrabbitAccessControlList);
    AccessControlEntry[] entries=((JackrabbitAccessControlList)policies[0]).getAccessControlEntries();
    assertEquals(1,entries.length);
    AccessControlEntry entry=entries[0];
    assertEquals("everyone",entry.getPrincipal().getName());
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
