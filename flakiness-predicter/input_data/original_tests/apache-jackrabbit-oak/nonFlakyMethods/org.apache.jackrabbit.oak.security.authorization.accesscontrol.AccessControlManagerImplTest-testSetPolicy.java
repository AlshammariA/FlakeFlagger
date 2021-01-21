@Test public void testSetPolicy() throws Exception {
  ACL acl=getApplicablePolicy(testPath);
  acl.addAccessControlEntry(testPrincipal,testPrivileges);
  acl.addEntry(EveryonePrincipal.getInstance(),testPrivileges,false,getGlobRestriction("*/something"));
  acMgr.setPolicy(testPath,acl);
  root.commit();
  Root root2=adminSession.getLatestRoot();
  AccessControlPolicy[] policies=getAccessControlManager(root2).getPolicies(testPath);
  assertEquals(1,policies.length);
  assertArrayEquals(acl.getAccessControlEntries(),((ACL)policies[0]).getAccessControlEntries());
}
