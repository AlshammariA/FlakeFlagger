public void testRemoveMixVersionable1() throws Exception {
  Node node=testRootNode.addNode(nodeName1);
  node.addMixin(mixReferenceable);
  node.addMixin(mixVersionable);
  superuser.save();
  node.removeMixin(mixVersionable);
  superuser.save();
}
