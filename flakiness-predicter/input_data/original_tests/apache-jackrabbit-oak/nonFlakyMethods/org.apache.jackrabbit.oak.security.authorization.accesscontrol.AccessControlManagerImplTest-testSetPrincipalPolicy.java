@Test public void testSetPrincipalPolicy() throws Exception {
  JackrabbitAccessControlPolicy[] applicable=acMgr.getApplicablePolicies(testPrincipal);
  assertNotNull(applicable);
  assertEquals(1,applicable.length);
  assertTrue(applicable[0] instanceof ACL);
  ACL acl=(ACL)applicable[0];
  Value pathValue=getValueFactory().createValue(testPath,PropertyType.PATH);
  assertTrue(acl.addEntry(testPrincipal,testPrivileges,true,Collections.singletonMap(REP_NODE_PATH,pathValue)));
  acMgr.setPolicy(acl.getPath(),acl);
  root.commit();
  Root root2=adminSession.getLatestRoot();
  AccessControlPolicy[] policies=getAccessControlManager(root2).getPolicies(testPath);
  assertEquals(1,policies.length);
  assertEquals(1,((ACL)policies[0]).getAccessControlEntries().length);
  policies=getAccessControlManager(root2).getPolicies(testPrincipal);
  assertEquals(1,policies.length);
  assertArrayEquals(acl.getAccessControlEntries(),((ACL)policies[0]).getAccessControlEntries());
}
