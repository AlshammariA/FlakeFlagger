public void testMultipleReferences1() throws RepositoryException {
  Node ref=testRootNode.addNode(nodeName2,testNodeType);
  ref.addMixin(mixReferenceable);
  superuser.save();
  Node n0=testRootNode.addNode(nodeName1,testNodeType);
  n0.setProperty("myref0",ref);
  Node n1=testRootNode.addNode(nodeName3,testNodeType);
  n1.setProperty("myref1",ref);
  superuser.save();
  checkReferences("refs",ref.getReferences("myref0"),n0.getPath() + "/myref0");
  checkReferences("refs",ref.getReferences("myref1"),n1.getPath() + "/myref1");
}
