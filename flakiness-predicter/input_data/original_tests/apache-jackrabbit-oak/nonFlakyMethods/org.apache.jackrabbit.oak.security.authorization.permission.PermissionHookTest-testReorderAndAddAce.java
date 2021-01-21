@Test public void testReorderAndAddAce() throws Exception {
  Tree entry=getEntry(testPrincipalName,testPath,0);
  assertIndex(0,entry);
  Tree aclTree=root.getTree(testPath + "/rep:policy");
  aclTree.getChildren().iterator().next().orderBefore(null);
  NodeUtil ace=new NodeUtil(aclTree).addChild("denyEveryoneLockMgt",NT_REP_DENY_ACE);
  ace.setString(REP_PRINCIPAL_NAME,EveryonePrincipal.NAME);
  ace.setStrings(AccessControlConstants.REP_PRIVILEGES,JCR_LOCK_MANAGEMENT);
  root.commit();
  entry=getEntry(testPrincipalName,testPath,1);
  assertIndex(1,entry);
}
