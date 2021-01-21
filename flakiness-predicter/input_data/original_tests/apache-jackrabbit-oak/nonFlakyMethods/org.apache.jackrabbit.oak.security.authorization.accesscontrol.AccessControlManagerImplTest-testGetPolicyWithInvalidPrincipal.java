@Test public void testGetPolicyWithInvalidPrincipal() throws Exception {
  ACL policy=getApplicablePolicy(testPath);
  policy.addEntry(testPrincipal,testPrivileges,true,getGlobRestriction("*"));
  acMgr.setPolicy(testPath,policy);
  NodeUtil aclNode=new NodeUtil(root.getTree(testPath + '/' + REP_POLICY));
  NodeUtil aceNode=aclNode.addChild("testACE",NT_REP_DENY_ACE);
  aceNode.setString(REP_PRINCIPAL_NAME,"invalidPrincipal");
  aceNode.setNames(REP_PRIVILEGES,PrivilegeConstants.JCR_READ);
  AccessControlPolicy[] policies=acMgr.getPolicies(testPath);
  assertNotNull(policies);
  assertEquals(1,policies.length);
  ACL acl=(ACL)policies[0];
  List<String> principalNames=new ArrayList<String>();
  for (  AccessControlEntry ace : acl.getEntries()) {
    principalNames.add(ace.getPrincipal().getName());
  }
  assertTrue(principalNames.remove("invalidPrincipal"));
  assertTrue(principalNames.remove(testPrincipal.getName()));
  assertTrue(principalNames.isEmpty());
}
