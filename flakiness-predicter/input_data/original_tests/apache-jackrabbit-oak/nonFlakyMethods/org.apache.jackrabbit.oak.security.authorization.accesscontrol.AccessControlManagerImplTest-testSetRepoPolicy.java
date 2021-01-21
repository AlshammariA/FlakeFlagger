@Test public void testSetRepoPolicy() throws Exception {
  ACL acl=getApplicablePolicy(null);
  acl.addAccessControlEntry(testPrincipal,privilegesFromNames(PrivilegeConstants.JCR_NAMESPACE_MANAGEMENT));
  acMgr.setPolicy(null,acl);
  root.commit();
  Root root2=adminSession.getLatestRoot();
  AccessControlPolicy[] policies=getAccessControlManager(root2).getPolicies((String)null);
  assertEquals(1,policies.length);
  assertArrayEquals(acl.getAccessControlEntries(),((ACL)policies[0]).getAccessControlEntries());
}
