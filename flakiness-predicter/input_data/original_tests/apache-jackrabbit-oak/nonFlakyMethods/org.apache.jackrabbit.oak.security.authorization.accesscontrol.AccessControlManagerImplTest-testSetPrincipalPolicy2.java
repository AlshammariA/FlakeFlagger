@Test public void testSetPrincipalPolicy2() throws Exception {
  setupPolicy(testPath);
  root.commit();
  JackrabbitAccessControlPolicy[] policies=acMgr.getPolicies(testPrincipal);
  assertNotNull(policies);
  assertEquals(1,policies.length);
  assertTrue(policies[0] instanceof ACL);
  ACL acl=(ACL)policies[0];
  Map<String,Value> restrictions=new HashMap<String,Value>();
  restrictions.put(REP_NODE_PATH,getValueFactory().createValue(testPath,PropertyType.PATH));
  assertTrue(acl.addEntry(testPrincipal,testPrivileges,true,restrictions));
  restrictions.putAll(getGlobRestriction("*"));
  assertFalse(acl.addEntry(testPrincipal,testPrivileges,true,restrictions));
  acMgr.setPolicy(acl.getPath(),acl);
  assertEquals(2,((ACL)acMgr.getPolicies(testPath)[0]).getAccessControlEntries().length);
}
