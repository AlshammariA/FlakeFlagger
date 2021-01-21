public void testMultipleReferences() throws RepositoryException {
  Node ref=testRootNode.addNode(nodeName2,testNodeType);
  ref.addMixin(mixReferenceable);
  superuser.save();
  Node n0=testRootNode.addNode(nodeName1,testNodeType);
  n0.setProperty("myref",ref);
  Node n1=testRootNode.addNode(nodeName3,testNodeType);
  n1.setProperty("myref",ref);
  superuser.save();
  checkReferences("refs",ref.getReferences(),n0.getPath() + "/myref",n1.getPath() + "/myref");
}
