@Test public void testModifyRestrictions() throws Exception {
  Tree testAce=root.getTree(testPath + "/rep:policy").getChildren().iterator().next();
  assertEquals(testPrincipalName,testAce.getProperty(REP_PRINCIPAL_NAME).getValue(Type.STRING));
  NodeUtil node=new NodeUtil(testAce);
  NodeUtil restrictions=node.addChild(REP_RESTRICTIONS,NT_REP_RESTRICTIONS);
  restrictions.setString(REP_GLOB,"*");
  String restrictionsPath=restrictions.getTree().getPath();
  root.commit();
  Tree principalRoot=getPrincipalRoot(testPrincipalName);
  assertEquals(2,cntEntries(principalRoot));
  Tree parent=principalRoot.getChildren().iterator().next();
  assertEquals("*",parent.getChildren().iterator().next().getProperty(REP_GLOB).getValue(Type.STRING));
  Tree restrictionsNode=root.getTree(restrictionsPath);
  restrictionsNode.setProperty(REP_GLOB,"/*/jcr:content/*");
  root.commit();
  principalRoot=getPrincipalRoot(testPrincipalName);
  assertEquals(2,cntEntries(principalRoot));
  parent=principalRoot.getChildren().iterator().next();
  assertEquals("/*/jcr:content/*",parent.getChildren().iterator().next().getProperty(REP_GLOB).getValue(Type.STRING));
  root.getTree(restrictionsPath).remove();
  root.commit();
  principalRoot=getPrincipalRoot(testPrincipalName);
  assertEquals(2,cntEntries(principalRoot));
  parent=principalRoot.getChildren().iterator().next();
  assertNull(parent.getChildren().iterator().next().getProperty(REP_GLOB));
}
