/** 
 * @since oak (DIFF: jr required jcr:versionManagement privilege on the version store)
 */
@Test public void testRemoveVersion3() throws Exception {
  Node n=createVersionableNode(superuser.getNode(path));
  Version v=n.checkin();
  n.checkout();
  n.checkin();
  testSession.refresh(false);
  assertFalse(testAcMgr.hasPrivileges(n.getPath(),versionPrivileges));
  AccessControlList acl=allow(SYSTEM,versionPrivileges);
  try {
    Node testNode=testSession.getNode(n.getPath());
    testNode.getVersionHistory().removeVersion(v.getName());
    fail("Missing jcr:versionManagement privilege -> remove a version must fail.");
  }
 catch (  AccessDeniedException e) {
  }
 finally {
    for (    AccessControlEntry entry : acl.getAccessControlEntries()) {
      if (entry.getPrincipal().equals(testUser.getPrincipal())) {
        acl.removeAccessControlEntry(entry);
      }
    }
    acMgr.setPolicy(SYSTEM,acl);
    superuser.save();
  }
}
