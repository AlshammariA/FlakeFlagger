@Test public void testReorderAddAndRemoveAces() throws Exception {
  Tree entry=getEntry(testPrincipalName,testPath,0);
  assertIndex(0,entry);
  Tree aclTree=root.getTree(testPath + "/rep:policy");
  aclTree.getChildren().iterator().next().orderBefore(null);
  Iterator<Tree> aceIt=aclTree.getChildren().iterator();
  aceIt.next().remove();
  String name=aceIt.next().getName();
  NodeUtil ace=new NodeUtil(aclTree).addChild("denyEveryoneLockMgt",NT_REP_DENY_ACE);
  ace.setString(REP_PRINCIPAL_NAME,EveryonePrincipal.NAME);
  ace.setStrings(AccessControlConstants.REP_PRIVILEGES,JCR_LOCK_MANAGEMENT);
  ace.getTree().orderBefore(name);
  root.commit();
  entry=getEntry(testPrincipalName,testPath,1);
  assertIndex(1,entry);
}
