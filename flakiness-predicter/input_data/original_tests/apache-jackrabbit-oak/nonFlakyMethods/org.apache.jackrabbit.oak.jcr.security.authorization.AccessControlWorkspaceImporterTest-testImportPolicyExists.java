/** 
 * Imports a resource-based ACL containing a single entry for a policy that already exists: expected outcome its that the existing ACE is replaced.
 */
public void testImportPolicyExists() throws Exception {
  try {
    Node target=createImportTargetWithPolicy(EveryonePrincipal.getInstance());
    doImport(target.getPath(),XML_POLICY_TREE_2);
    AccessControlManager acMgr=superuser.getAccessControlManager();
    AccessControlPolicy[] policies=acMgr.getPolicies(target.getPath());
    assertEquals(1,policies.length);
    assertTrue(policies[0] instanceof JackrabbitAccessControlList);
    AccessControlEntry[] entries=((JackrabbitAccessControlList)policies[0]).getAccessControlEntries();
    assertEquals(1,entries.length);
    AccessControlEntry entry=entries[0];
    assertEquals(EveryonePrincipal.getInstance(),entry.getPrincipal());
    List<Privilege> privs=Arrays.asList(entry.getPrivileges());
    assertEquals(1,privs.size());
    assertEquals(acMgr.privilegeFromName(Privilege.JCR_WRITE),entry.getPrivileges()[0]);
    if (entry instanceof JackrabbitAccessControlEntry) {
      assertTrue(((JackrabbitAccessControlEntry)entry).isAllow());
    }
  }
  finally {
    superuser.refresh(false);
  }
}
