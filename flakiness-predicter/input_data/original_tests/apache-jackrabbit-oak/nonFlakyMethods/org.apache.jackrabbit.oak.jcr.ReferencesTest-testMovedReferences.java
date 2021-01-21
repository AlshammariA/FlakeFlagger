public void testMovedReferences() throws RepositoryException {
  Node ref=testRootNode.addNode(nodeName2,testNodeType);
  ref.addMixin(mixReferenceable);
  superuser.save();
  Node n=testRootNode.addNode(nodeName1,testNodeType);
  n.setProperty("myref",ref);
  superuser.save();
  String newPath=testRootNode.getPath() + "/" + nodeName3;
  superuser.move(ref.getPath(),newPath);
  superuser.save();
  ref=superuser.getNode(newPath);
  assertEquals("ref",ref.getPath(),n.getProperty("myref").getNode().getPath());
  checkReferences("refs",ref.getReferences(),n.getPath() + "/myref");
}
