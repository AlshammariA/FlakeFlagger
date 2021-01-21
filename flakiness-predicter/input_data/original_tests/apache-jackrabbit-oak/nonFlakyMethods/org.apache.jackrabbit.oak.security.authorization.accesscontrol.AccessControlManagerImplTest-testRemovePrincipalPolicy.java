@Test public void testRemovePrincipalPolicy() throws Exception {
  JackrabbitAccessControlPolicy[] applicable=acMgr.getApplicablePolicies(testPrincipal);
  assertNotNull(applicable);
  assertEquals(1,applicable.length);
  assertTrue(applicable[0] instanceof ACL);
  ACL acl=(ACL)applicable[0];
  Value pathValue=getValueFactory().createValue(testPath,PropertyType.PATH);
  assertTrue(acl.addEntry(testPrincipal,testPrivileges,true,Collections.singletonMap(REP_NODE_PATH,pathValue)));
  acMgr.setPolicy(acl.getPath(),acl);
  root.commit();
  acMgr.removePolicy(acl.getPath(),acl);
  root.commit();
  assertEquals(0,acMgr.getPolicies(testPrincipal).length);
  assertEquals(0,acMgr.getPolicies(testPath).length);
}
