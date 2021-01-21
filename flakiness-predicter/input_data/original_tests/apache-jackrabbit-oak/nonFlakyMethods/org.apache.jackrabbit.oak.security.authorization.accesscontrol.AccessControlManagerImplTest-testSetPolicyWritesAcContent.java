@Test public void testSetPolicyWritesAcContent() throws Exception {
  ACL acl=getApplicablePolicy(testPath);
  acl.addAccessControlEntry(testPrincipal,testPrivileges);
  acl.addEntry(EveryonePrincipal.getInstance(),testPrivileges,false,getGlobRestriction("*/something"));
  acMgr.setPolicy(testPath,acl);
  root.commit();
  Root root2=adminSession.getLatestRoot();
  Tree tree=root2.getTree(testPath);
  assertTrue(tree.hasChild(REP_POLICY));
  Tree policyTree=tree.getChild(REP_POLICY);
  assertEquals(NT_REP_ACL,TreeUtil.getPrimaryTypeName(policyTree));
  assertEquals(2,policyTree.getChildrenCount(3));
  Iterator<Tree> children=policyTree.getChildren().iterator();
  Tree ace=children.next();
  assertEquals(NT_REP_GRANT_ACE,TreeUtil.getPrimaryTypeName(ace));
  assertEquals(testPrincipal.getName(),TreeUtil.getString(ace,REP_PRINCIPAL_NAME));
  assertEquals(newHashSet(testPrivileges),newHashSet(privilegesFromNames(TreeUtil.getStrings(ace,REP_PRIVILEGES))));
  assertFalse(ace.hasChild(REP_RESTRICTIONS));
  Tree ace2=children.next();
  assertEquals(NT_REP_DENY_ACE,TreeUtil.getPrimaryTypeName(ace2));
  assertEquals(EveryonePrincipal.NAME,ace2.getProperty(REP_PRINCIPAL_NAME).getValue(Type.STRING));
  Privilege[] privs=privilegesFromNames(TreeUtil.getNames(ace2,REP_PRIVILEGES));
  assertEquals(newHashSet(testPrivileges),newHashSet(privs));
  assertTrue(ace2.hasChild(REP_RESTRICTIONS));
  Tree restr=ace2.getChild(REP_RESTRICTIONS);
  assertEquals("*/something",restr.getProperty(REP_GLOB).getValue(Type.STRING));
}
