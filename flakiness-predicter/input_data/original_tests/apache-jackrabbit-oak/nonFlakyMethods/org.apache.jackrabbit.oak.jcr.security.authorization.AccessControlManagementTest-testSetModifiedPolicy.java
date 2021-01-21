@Test public void testSetModifiedPolicy() throws Exception {
  Privilege[] privileges=privilegesFromNames(new String[]{REP_WRITE,Privilege.JCR_READ_ACCESS_CONTROL,Privilege.JCR_MODIFY_ACCESS_CONTROL});
  JackrabbitAccessControlList acl=allow(path,privileges);
  AccessControlPolicy[] policies=testAcMgr.getPolicies(path);
  assertEquals(1,policies.length);
  assertTrue(policies[0] instanceof AccessControlList);
  AccessControlList policy=(AccessControlList)policies[0];
  if (policy.addAccessControlEntry(testUser.getPrincipal(),privilegesFromName(Privilege.JCR_LOCK_MANAGEMENT))) {
    testAcMgr.setPolicy(path,acl);
    testSession.save();
  }
}
