@Test public void testAccessControlModification() throws Exception {
  Privilege[] privileges=privilegesFromNames(new String[]{Privilege.JCR_READ_ACCESS_CONTROL,Privilege.JCR_MODIFY_ACCESS_CONTROL});
  JackrabbitAccessControlList tmpl=allow(path,privileges);
  assertTrue(superuser.itemExists(tmpl.getPath() + "/rep:policy"));
  assertTrue(testAcMgr.hasPrivileges(path,privilegesFromName(Privilege.JCR_MODIFY_ACCESS_CONTROL)));
  AccessControlPolicy[] policies=testAcMgr.getPolicies(path);
  testAcMgr.getPolicies(childNPath);
  try {
    testAcMgr.getPolicies(siblingPath);
    fail("READ_AC privilege must not apply outside of the tree it has applied to.");
  }
 catch (  AccessDeniedException e) {
  }
  assertFalse(testAcMgr.hasPrivileges(siblingPath,privilegesFromName(Privilege.JCR_MODIFY_ACCESS_CONTROL)));
  AccessControlList acl=(AccessControlList)policies[0];
  acl.addAccessControlEntry(testUser.getPrincipal(),repWritePrivileges);
  testAcMgr.setPolicy(path,acl);
  testSession.save();
  assertTrue(testAcMgr.hasPrivileges(path,privilegesFromName(Privilege.JCR_REMOVE_CHILD_NODES)));
  testAcMgr.removePolicy(path,policies[0]);
  testSession.save();
  try {
    testAcMgr.getEffectivePolicies(childNPath);
    fail("READ_AC privilege has been revoked -> must throw again.");
  }
 catch (  AccessDeniedException e) {
  }
  assertReadOnly(path);
}
