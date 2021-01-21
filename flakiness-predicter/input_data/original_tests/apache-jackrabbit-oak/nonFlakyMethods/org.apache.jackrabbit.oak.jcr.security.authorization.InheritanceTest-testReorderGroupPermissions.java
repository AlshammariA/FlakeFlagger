@Test public void testReorderGroupPermissions() throws Exception {
  deny(path,testGroup.getPrincipal(),modPropPrivileges);
  allow(path,group2.getPrincipal(),modPropPrivileges);
  String actions=getActions(Session.ACTION_SET_PROPERTY,Session.ACTION_READ);
  assertTrue(testSession.hasPermission(path,actions));
  Privilege[] privs=privilegesFromName(Privilege.JCR_MODIFY_PROPERTIES);
  assertTrue(testAcMgr.hasPrivileges(path,privs));
  AccessControlEntry srcEntry=null;
  AccessControlEntry destEntry=null;
  JackrabbitAccessControlList acl=(JackrabbitAccessControlList)acMgr.getPolicies(path)[0];
  for (  AccessControlEntry entry : acl.getAccessControlEntries()) {
    Principal princ=entry.getPrincipal();
    if (testGroup.getPrincipal().equals(princ)) {
      destEntry=entry;
    }
 else     if (group2.getPrincipal().equals(princ)) {
      srcEntry=entry;
    }
  }
  acl.orderBefore(srcEntry,destEntry);
  acMgr.setPolicy(path,acl);
  superuser.save();
  testSession.refresh(false);
  assertFalse(testSession.hasPermission(path,actions));
  assertFalse(testAcMgr.hasPrivileges(path,privs));
}
