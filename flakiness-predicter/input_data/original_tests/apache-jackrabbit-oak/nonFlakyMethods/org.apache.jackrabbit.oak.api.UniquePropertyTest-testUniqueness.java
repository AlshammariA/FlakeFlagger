@Test public void testUniqueness() throws Exception {
  Root root=new Oak().with(new OpenSecurityProvider()).with(new PropertyIndexEditorProvider()).with(new InitialContent()).createRoot();
  NodeUtil node=new NodeUtil(root.getTree("/"));
  String uuid=UUID.randomUUID().toString();
  node.setString(JcrConstants.JCR_UUID,uuid);
  root.commit();
  NodeUtil child=new NodeUtil(root.getTree("/")).addChild("another","rep:User");
  child.setString(JcrConstants.JCR_UUID,uuid);
  try {
    root.commit();
    fail("Duplicate jcr:uuid should be detected.");
  }
 catch (  CommitFailedException e) {
  }
}
