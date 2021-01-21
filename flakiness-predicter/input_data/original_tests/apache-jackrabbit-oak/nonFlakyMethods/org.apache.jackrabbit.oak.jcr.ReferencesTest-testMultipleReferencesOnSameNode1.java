public void testMultipleReferencesOnSameNode1() throws RepositoryException {
  Node ref=testRootNode.addNode(nodeName2,testNodeType);
  ref.addMixin(mixReferenceable);
  superuser.save();
  Node n=testRootNode.addNode(nodeName1,testNodeType);
  n.setProperty("myref0",ref);
  n.setProperty("myref1",ref);
  superuser.save();
  assertEquals("ref",ref.getPath(),n.getProperty("myref0").getNode().getPath());
  assertEquals("ref",ref.getPath(),n.getProperty("myref1").getNode().getPath());
  checkReferences("refs",ref.getReferences("myref0"),n.getPath() + "/myref0");
  checkReferences("refs",ref.getReferences("myref1"),n.getPath() + "/myref1");
}
