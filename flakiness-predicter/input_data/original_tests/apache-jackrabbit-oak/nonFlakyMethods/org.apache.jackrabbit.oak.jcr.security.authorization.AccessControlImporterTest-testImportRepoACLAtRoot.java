/** 
 * Repo level acl must be imported underneath the root node.
 * @throws Exception
 */
public void testImportRepoACLAtRoot() throws Exception {
  Node target=superuser.getRootNode();
  AccessControlManager acMgr=superuser.getAccessControlManager();
  try {
    target.addMixin("rep:RepoAccessControllable");
    if (!isSessionImport()) {
      superuser.save();
    }
    doImport(target.getPath(),XML_REPO_POLICY_TREE);
    AccessControlPolicy[] policies=acMgr.getPolicies(null);
    assertEquals(1,policies.length);
    assertTrue(policies[0] instanceof JackrabbitAccessControlList);
    AccessControlEntry[] entries=((JackrabbitAccessControlList)policies[0]).getAccessControlEntries();
    assertEquals(1,entries.length);
    assertEquals(1,entries[0].getPrivileges().length);
    assertEquals(acMgr.privilegeFromName("jcr:workspaceManagement"),entries[0].getPrivileges()[0]);
    assertTrue(target.hasNode("rep:repoPolicy"));
    assertTrue(target.hasNode("rep:repoPolicy/allow"));
    acMgr.removePolicy(null,policies[0]);
    assertFalse(target.hasNode("rep:repoPolicy"));
    assertFalse(target.hasNode("rep:repoPolicy/allow"));
  }
  finally {
    if (isSessionImport()) {
      superuser.refresh(false);
    }
 else {
      superuser.save();
    }
    assertEquals(0,acMgr.getPolicies(null).length);
  }
}
