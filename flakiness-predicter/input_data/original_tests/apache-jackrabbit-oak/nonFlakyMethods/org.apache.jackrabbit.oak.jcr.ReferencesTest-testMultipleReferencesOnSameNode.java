public void testMultipleReferencesOnSameNode() throws RepositoryException {
  Node ref=testRootNode.addNode(nodeName2,testNodeType);
  ref.addMixin(mixReferenceable);
  superuser.save();
  Node n=testRootNode.addNode(nodeName1,testNodeType);
  n.setProperty("myref0",ref);
  n.setProperty("myref1",ref);
  superuser.save();
  assertEquals("ref",ref.getPath(),n.getProperty("myref0").getNode().getPath());
  assertEquals("ref",ref.getPath(),n.getProperty("myref1").getNode().getPath());
  checkReferences("refs",ref.getReferences(),n.getPath() + "/myref0",n.getPath() + "/myref1");
}
