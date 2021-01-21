public void testSimpleReferences() throws RepositoryException {
  Node ref=testRootNode.addNode(nodeName2,testNodeType);
  ref.addMixin(mixReferenceable);
  superuser.save();
  Node n=testRootNode.addNode(nodeName1,testNodeType);
  n.setProperty("myref",ref);
  superuser.save();
  assertEquals("ref",ref.getPath(),n.getProperty("myref").getNode().getPath());
  checkReferences("refs",ref.getReferences(),n.getPath() + "/myref");
}
