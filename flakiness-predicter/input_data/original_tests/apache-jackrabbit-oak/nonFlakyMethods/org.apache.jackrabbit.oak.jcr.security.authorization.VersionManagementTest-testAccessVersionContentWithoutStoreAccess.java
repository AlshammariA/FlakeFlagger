/** 
 * @since oak
 */
@Test public void testAccessVersionContentWithoutStoreAccess() throws Exception {
  Node n=createVersionableNode(superuser.getNode(path));
  Version v=n.checkin();
  VersionHistory vh=n.getVersionHistory();
  n.checkout();
  Version v2=n.checkin();
  n.checkout();
  testSession.refresh(false);
  assertFalse(testAcMgr.hasPrivileges(n.getPath(),versionPrivileges));
  AccessControlList acl=deny(SYSTEM,privilegesFromName(Privilege.JCR_READ));
  try {
    assertTrue(testSession.nodeExists(v.getPath()));
    assertTrue(testSession.nodeExists(v2.getPath()));
    assertTrue(testSession.nodeExists(vh.getPath()));
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
