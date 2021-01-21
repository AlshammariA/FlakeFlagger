public void testVersionedReferences() throws RepositoryException {
  Node ref=testRootNode.addNode(nodeName2,testNodeType);
  ref.addMixin(mixReferenceable);
  superuser.save();
  Node n=testRootNode.addNode(nodeName1,testNodeType);
  n.addMixin(mixVersionable);
  n.setProperty("myref",ref);
  superuser.save();
  String p=n.getPath();
  VersionManager vMgr=superuser.getWorkspace().getVersionManager();
  Version v1=vMgr.checkpoint(p);
  Node frozen=v1.getFrozenNode();
  assertEquals("ref",ref.getPath(),frozen.getProperty("myref").getNode().getPath());
  checkReferences("ref in version store",ref.getReferences(),n.getPath() + "/myref");
  n.remove();
  ref.remove();
  superuser.save();
  try {
    frozen.getProperty("myref").getNode();
    fail("removed reference should not be accessible");
  }
 catch (  ItemNotFoundException e) {
  }
}
